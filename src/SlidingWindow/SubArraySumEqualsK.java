package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    /*
        Input: nums = [1,2,3], k = 3
        Output: 2
     */

    public static int countSubArraySumEqualK(int[] nums, int k){
        if(nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> indexMap = new HashMap<>(); // {sum, count}
        indexMap.put(0 , 1);

        int prefixSum = 0;
        int count = 0;
        for(int index = 0; index < nums.length; index++){
            prefixSum += nums[index];

            if(indexMap.containsKey(prefixSum-k)){
                count += indexMap.get(prefixSum-k);
            }
            indexMap.put(prefixSum, indexMap.getOrDefault(prefixSum , 0) + 1);
        }
        System.out.println(indexMap);
        System.out.println("Result : " + count);
        return count;
    }


    public static void main(String[] args) {
        int[] nums = { 1,2,3} ;
        int k = 3;

        countSubArraySumEqualK(nums, k);
    }
}
