package BinarySearch;

/**
 * find out number with single occurrence.
 */
public class Q8_Single_element_in_sorted_array {


    /**
     * Binary Search
     * Time Complexity - o(log n)
     * Space Complexity - o(1)
     * @return Index Of Single Element.
     */
    public static int getSingleElementIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int n = arr.length;

        if (arr.length == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return mid;
            }

            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                    (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] input = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6};

        int index = getSingleElementIndex(input);
        System.out.println(" SingleElement  : " + input[index]);
    }
}
