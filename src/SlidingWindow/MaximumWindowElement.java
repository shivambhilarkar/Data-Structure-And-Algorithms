package SlidingWindow;


import java.util.ArrayDeque;

/**
 * Fixed Size Window
 */
public class MaximumWindowElement {

    /*
        Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
        Output: [3,3,5,5,6,7]
        Explanation:
        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7
     */


    public static int[] getMaxWindowElements(int[] nums, int windowSize) {
        if (nums == null || nums.length == 0) return new int[]{};

        final ArrayDeque<Integer> indexQueue = new ArrayDeque<>();
        final int[] result = new int[nums.length - windowSize + 1];
        int rIndex = 0;

        for (int index = 0; index < nums.length; index++) {
            int currentElement = nums[index];

            //remove out of bound elements.
            if (!indexQueue.isEmpty() && indexQueue.peekFirst() <= index - windowSize) {
                indexQueue.removeFirst();
            }

            //maintain monotonic queue property
            while (!indexQueue.isEmpty() && nums[indexQueue.peekLast()] <= currentElement) {
                indexQueue.removeLast();
            }
            //add index to queue
            indexQueue.add(index);

            if (index >= windowSize - 1) {
                result[rIndex] = nums[indexQueue.peekFirst()];
                rIndex += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        getMaxWindowElements(nums, k);
    }
}
