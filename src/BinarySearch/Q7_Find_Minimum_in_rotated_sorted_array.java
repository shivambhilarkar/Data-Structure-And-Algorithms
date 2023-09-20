package BinarySearch;

/**
 * Input has unique numbers.
 * return minimum number.
 */
public class Q7_Find_Minimum_in_rotated_sorted_array {

    /**
     * Brute Force* Use for loop to get minimum number and return it.
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     */

    /**
     * Binary Search
     * Time Complexity - o(log n)
     * Space Complexity - o(n)
     */
    public static int findMinimumNumber(int[] input) {
        if (input == null || input.length == 0) return Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            //identify sorted half
            if (input[low] <= input[mid]) {
                ans = Math.min(ans, input[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, input[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(" Minimum Number : " + findMinimumNumber(input));
    }
}
