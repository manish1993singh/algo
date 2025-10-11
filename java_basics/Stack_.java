package java_basics;

import java.util.Stack;

public class Stack_ {
    public static void main(String[] args) {
        // Using Java's inbuilt Stack class
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushes: " + stack);

        // Peek at the top element
        System.out.println("Top element is: " + stack.peek());

        // Pop the top element
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Search for an element (returns 1-based position from top, or -1 if not found)
        int position = stack.search(10);
        System.out.println("Position of 10 from top: " + position);

        // Real-world use case: Undo functionality in editors
        // Each action is pushed onto the stack; undo pops the last action
        Stack<String> actions = new Stack<>();
        actions.push("Type 'Hello'");
        actions.push("Bold 'Hello'");
        actions.push("Type 'World'");
        System.out.println("Action stack: " + actions);
        System.out.println("Undo action: " + actions.pop()); // Undo last action
        System.out.println("Current action stack: " + actions);

        // Real-world use case: Expression evaluation (e.g., parentheses matching)
        String expr = "((2+3)*5)";
        System.out.println("Is parentheses balanced in '" + expr + "'? " + isParenthesesBalanced(expr));
    }

    // Example: Real-world use case for stack - Parentheses matching
    public static boolean isParenthesesBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}