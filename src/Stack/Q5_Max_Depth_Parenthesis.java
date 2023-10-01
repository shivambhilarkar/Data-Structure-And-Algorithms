package Stack;


public class Q5_Max_Depth_Parenthesis {

    /**
     * Time Complexity - o(n)
     * Space Complexity - o(n)
     */
    public int getMaximumDepth(String input) {
        if (input == null || input.isEmpty()) return 0;

        int maxDepth = 0;
        int currentDepth = 0;
        for (Character ch : input.toCharArray()) {
            if (ch == '(') {
                currentDepth += 1;
            } else {
                maxDepth = Math.max(currentDepth, maxDepth);
                currentDepth -= 1;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {

    }
}
