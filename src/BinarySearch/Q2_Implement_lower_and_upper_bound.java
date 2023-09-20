package BinarySearch;

public class Q2_Implement_lower_and_upper_bound {

    /**
     * Lower Bound - smallest index such that arr[index] >= target.
     * Upper Bound - smallest index such that arr[index] > target.
     */

    /**
     * Brute Force
     * Use for loop to find out lowerBound and upperBound for target number.
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     */


    /**
     * Optimal approach
     * Time Complexity - o(log n)
     * Space Complexity - o(1)
     */
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int ans = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // greater than equal to target
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int ans = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //greater than target
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        System.out.println(" Lower Bound Index : " + lowerBound(nums, target));
        System.out.println(" Upper Bound Index : " + upperBound(nums, target));

    }
}
