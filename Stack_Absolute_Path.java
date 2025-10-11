import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Stack_Absolute_Path {
    public String simplifyPath(String A) {
        
        String[] parts = A.split("/");
        ArrayList<String> path = new ArrayList<>(Arrays.asList(parts));
        
        Stack<String> stack = new Stack<>();
        insert(stack, path);
        String result = out(stack);
        return result;
    }
    
    public void insert(Stack<String> stack, ArrayList<String> path){
        for(String part: path){
            if(part.equals(".") || part.equals("")){
                continue;
            }
            if(part.equals("..")){
                stack.pop();
            }else{
                stack.push(part);
            }
        }
    }
    public String out(Stack<String> stack){
        String path = "";
        for(String part: stack){
            path += "/"+part;
        }
        return path;
    }

    public static void main(String[] args){
        // String str = "((2+5))";
        String str = "/a/./b/../../c/";
        String result = new Stack_Absolute_Path().simplifyPath(str);
        System.out.print(result);
    }
}

