package Stack;

import java.util.Stack;

public class Q6_Reverse_Parenthesis {

    /**
     * Get count of reverse parenthesis to make string valid.
     * Time Complexity - o(n)
     * Space Complexity - o(n)
     *
     * @param input String = "))((())(())
     */
    public static int getReverseParenthesisCount(String input) {
        if (input == null || input.isEmpty()) return 0;

        Stack<Character> stack = new Stack<>();
        int openBracket = 0;
        int closeBracket = 0;
        for (Character ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                openBracket += 1;
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.push(ch);
                    closeBracket += 1;
                } else {
                    stack.pop();
                    openBracket -= 1;
                }
            }
        }
        int answer = (int) Math.ceil(openBracket / 2.0) + (int) Math.ceil(closeBracket / 2.0);
        return answer;
    }

    public static void main(String[] args) {
        String input = ")(())(((";
        //answer 3 reversal
        System.out.println("[ Input : " + input + " | Result : " + getReverseParenthesisCount(input) + " ]");

    }
}
