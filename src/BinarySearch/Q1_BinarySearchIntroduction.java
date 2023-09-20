package BinarySearch;

public class Q1_BinarySearchIntroduction {

    /**
     * Binary Search Iterative.
     * Time Complexity - o(log n)
     * Space Complexity - o(1)
     * find out target number is present in array or not.
     *
     * @return boolean flag
     */
    public static boolean iterativeBinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    /**
     * Recursive Binary Searchs
     * Time Complexity  - o(log n)
     * Space Complexity - o(1)
     */
    public static boolean recursiveBinarySearch(int[] nums, int low, int high, int target) {
        if (nums == null || nums.length == 0) return false;

        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            return recursiveBinarySearch(nums, mid + 1, high, target);
        } else {
            return recursiveBinarySearch(nums, low, mid - 1, target);
        }
    }


    public static void main(String[] args) {

        int[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(iterativeBinarySearch(numArray, 8));
        System.out.println(iterativeBinarySearch(numArray, 10));
    }
}
