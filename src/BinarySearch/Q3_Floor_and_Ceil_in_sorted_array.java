package BinarySearch;

public class Q3_Floor_and_Ceil_in_sorted_array {

    /**
     * Floor - largest number in array which is <= target.
     * Ceil - smallest number in array which is >= target.
     */

    /**
     * Brute Force
     * use for loop to find out floor and ceil of number.
     * Time Complexity - o(n)
     * Space Complexity - o(log n)
     */

    public static int getFloor(int[] nums, int target) {
        if (nums == null || nums.length == 0) return target;

        int floor = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    public static int getCeil(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int ceil = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 7, 8, 9};
        int target = 6;

        System.out.println(" Floor : " + getFloor(nums, target));
        System.out.println(" Ceil  : " + getCeil(nums, target));
    }

}
