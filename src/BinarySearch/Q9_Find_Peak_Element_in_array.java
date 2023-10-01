package BinarySearch;

public class Q9_Find_Peak_Element_in_array {

    /**
     * Brute Force Approach
     * User for loop to identify peak element.
     */

    /**
     * Binary Search
     * Time Complexity - o(log n)
     * Space Complexity - o(1)
     */
    public static int findPeak(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        //handle edge case & if conditions from inside while loop
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1]) return nums[0];
        if (nums[n - 1] > nums[n - 2]) return nums[n - 1];

        //trim down search space from both ends
        int low = 1;
        int high = nums.length - 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
