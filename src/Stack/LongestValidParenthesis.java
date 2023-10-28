package Stack;

import java.util.ArrayDeque;

public class LongestValidParenthesis {

    public static int longestValidParenthesis(String pattern){
        if(pattern == null || pattern.isEmpty()) return 0;

        ArrayDeque<Integer> indexStack = new ArrayDeque<>();
        indexStack.push(-1);

        int result = 0;
        char[] brackets = pattern.toCharArray();
        for(int i = 0; i < brackets.length; i++){
            if(brackets[i] == '('){
                indexStack.push(i);
            }else {
                indexStack.pop();
                if (indexStack.isEmpty()) {
                    indexStack.push(i);
                } else {
                    result = Math.max(result, i - indexStack.peek());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String pattern = "(()))())))";
    }
}
