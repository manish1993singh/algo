import java.util.Stack;

public class Stack_String_Reverse {
    public String reverseString(String A) {
        Stack<Character> stack = new Stack<>();
        for(char c: A.toCharArray()){
            stack.push(c);
        }
        String reverse = "";
        for(char c: stack){
            reverse += Character.toString(c);
        }

        while(stack.size() > 0){
            reverse += stack.pop();
        }
        
        return reverse;
    }

    public static void main(String[] args){
        String str = "abc";
        String result = new Stack_String_Reverse().reverseString(str);
        System.out.print(result);
    }
}