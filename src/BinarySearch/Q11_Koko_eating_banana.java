package BinarySearch;

public class Q11_Koko_eating_banana {


    /**
     * Binary Search
     * Time Complexity - o(log n)
     * Space Complexity - o(1)
     */
    public static int getEatingSpeed(int[] nums, int hours) {
        if (nums == null || nums.length == 0) return 0;

        int maxPileBananas = 0;
        for (int num : nums) maxPileBananas = Math.max(num, maxPileBananas);

        int low = 1;
        int high = maxPileBananas;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (getTimeToEat(nums, hours) <= hours) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int getTimeToEat(int[] bananas, int hour) {
        int hoursCount = 0;
        for (int banana : bananas) {
            hoursCount += Math.ceil((double) banana / (double) hour);
        }
        return hoursCount;
    }


    public static void main(String[] args) {

    }
}
