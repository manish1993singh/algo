

import java.util.Stack;

public class Stack_bracket {
    public int isValid(String A) {
        //create an stack of characters 
        //push in stack if character is (, {, [
        //pop if character is ), }, ]
        //if mismatch, then return 0
        //if stack size is there return 0
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++){
            char c = A.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' || c == '}' || c == ']'){
                if(stack.size() <= 0){
                    stack.push(c);
                    continue;
                }
                char popedChar = stack.peek();
                if(c == ')' && popedChar != '(' || c == '}' && popedChar != '{' || c == ']' && popedChar != '['){
                    break;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.size() > 0){
            return 0;
        }
        return 1;
    }

    public static void main(String[] arga){
        // String str = "((((([{()}[]]]{{{[]}}})))))";
        String str  = "])";
        int result = new Stack_bracket().isValid(str);
        System.out.println(result);
    }
}
