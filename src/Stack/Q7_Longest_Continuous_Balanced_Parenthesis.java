package Stack;

import java.util.Stack;

public class Q7_Longest_Continuous_Balanced_Parenthesis {

    /**
     * Time Complexity - o(n)
     * Space Complexity - o(n)
     */
    public static int getLongestContinuousParenthesis(String input) {
        if (input == null || input.isEmpty()) return 0;

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1); //index -1
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == '(') {
                stack.push(index);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result = Math.max(result, index - stack.peek());
                } else {
                    stack.push(index);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
