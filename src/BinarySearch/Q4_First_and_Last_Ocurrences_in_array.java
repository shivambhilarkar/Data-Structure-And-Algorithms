package BinarySearch;


/**
 * 1.find out first and last ocurrences of element in sorted array.
 * 2.find out number of ocurrences of elemnent in sorted array.
 */
public class Q4_First_and_Last_Ocurrences_in_array {


    /**
     * Brute Force
     * use for loop to track firstIndex and lastIndex of target element.
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     */

    /**
     * Binary Search
     * Time Complexity - o(log n)
     * Space Complexity - o(1)
     */

    public static int getFirstIndex(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;

        int firstIndex = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == target) {
                firstIndex = mid;
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return firstIndex;
    }

    public static int getLastIndex(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;
        int lastIndex = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                lastIndex = mid;
                low = mid + 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return lastIndex;
    }




    public static void main(String[] args) {

        int[] nums = {1,2,3, 4, 4, 4, 4, 4, 4,5,6,7,8,9};
        int target = 4;

        System.out.println(" First Index : "+ getFirstIndex(nums, target));
        System.out.println(" Last Index  : "+ getLastIndex(nums, target));

        /**
         * Number of ocurrences ?
         */
        System.out.println(" Result : "+( getLastIndex(nums, target) - getFirstIndex(nums, target) + 1));
    }


}
