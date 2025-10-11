import java.util.Stack;

public class Stack_Redundent_bracket {
    public int braces(String A) {
        //create an stack of characters 
        //push in stack if character is (, {, [
        //pop if character is ), }, ]
        //if mismatch, then return 0
        //if stack size is there return 0
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++){
            char c = A.charAt(i);
            if(c == '(' ){
                stack.push(c);
            }else if(c == '+' || c == '-' || c == '*' || c == '/' ){
                if(stack.size() > 0){
                    char b = stack.peek();
                if(b == '(' || b == ')'){
                    stack.push(c);
                }
                }
                
            }else if(c == ')'){
                if(stack.size() <= 0){
                    return 1;
                }
                stack.pop();
                if(stack.size() <= 0){
                    return 1;
                }
                char popedCharTwo = stack.pop();
                if(c == ')' && popedCharTwo != '(' ){
                    return 1;
                }
            }
        }
        if(stack.size() > 0){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        // String str = "((2+5))";
        String str = "(a+(a+b))";
        int result = new Stack_Redundent_bracket().braces(str);
        System.out.print(result);
    }
}