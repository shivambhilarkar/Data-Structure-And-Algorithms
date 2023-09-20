package BinarySearch;

/**
 * Input has Unique Numbers.
 * Need to return index if found else return -1.
 */
public class Q5_Search_in_rotated_sorted_array {

    /**
     * Brute Force approach
     * use for loop to search element is present or not.
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     */

    /**
     * Binary Search approach
     * - identify the sorted half and then check for target
     * Time Complexity - o(log n)
     * Space Complexity - o(1)
     */
    public static int searchElement(int[] input, int target) {
        if (input == null || input.length == 0) return -1;

        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (input[mid] == target) return mid;

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
        return -1; //not found.
    }


    public static void main(String[] args) {

        int[] input = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        System.out.println(" Target : " + 4 + " Result : " + searchElement(input, 4));
        System.out.println(" Target : " + 9 + " Result : " + searchElement(input, 9));
        System.out.println(" Target : " + 10 + " Result : " + searchElement(input, 10));
    }


}
