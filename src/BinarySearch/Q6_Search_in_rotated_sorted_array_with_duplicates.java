package BinarySearch;

/**
 * Input has duplicate numbers.
 * Need to return boolean if present return true else return false.
 */
public class Q6_Search_in_rotated_sorted_array_with_duplicates {

    /**
     * Brute Force approach
     * Use for loop to search the element and return result.
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     */

    /**
     * Binary Search
     * Time Complexity - o(log n)  / max complexity can be o(n) on edge case.
     * Space Complexity - o(1)
     */
    public static boolean findNumber(int[] input, int target) {
        if (input == null || input.length == 0) return false;

        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (input[mid] == target) return true;

            //trim down search space from both end
            if (input[low] == input[high]) {
                low += 1;
                high -= 1;
                continue;
            }

            //identify sorted half
            if (input[low] <= input[mid]) {
                if (input[low] <= target && target <= input[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (input[mid] <= target && target <= input[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] input = {6, 6, 7, 8, 9, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6};

        System.out.println(" IsPresent : " + findNumber(input, 6));
        System.out.println(" IsPresent : " + findNumber(input, 4));
        System.out.println(" IsPresent : " + findNumber(input, 10));
    }
}
