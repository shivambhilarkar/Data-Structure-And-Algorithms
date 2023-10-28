package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*
        Input: nums = [100,4,200,1,3,2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     */

    public static int longestConsecutiveSeq(int[] numbers){
        if(numbers == null || numbers.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : numbers) set.add(num);

        int maxLength = 0;

        for(int num : numbers){
            if(!set.contains(num - 1)){
                int count = 1;
                int startValue = num;
                while(set.contains(startValue+1)){
                    startValue += 1;
                    count += 1;
                }
                maxLength = Math.max(count, maxLength);
            }
        }
        return maxLength;
    }



    public static void main(String[] args) {
        int[] nums = { 100,4,200,1,3,2 };
        System.out.println("Result : "+ longestConsecutiveSeq(nums));
    }
}
