package Stack;

import java.util.Stack;

/**
 * Validate Parenthesis expression.
 */
public class Q4_Balanced_parenthesis {

    /**
     * Time Complexity - o(n)
     * Space Complexity - o(n)
     */
    public boolean validateExpression(String input) {
        if (input == null || input.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        for (Character ch : input.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != ']') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '}') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

    }
}
