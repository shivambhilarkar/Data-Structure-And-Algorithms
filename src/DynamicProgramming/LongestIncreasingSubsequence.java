package DynamicProgramming;

public class LongestIncreasingSubsequence {

    /*
        Return length of longest increasing subsequence.
     */
    public static int lis(int[] nums){
        if(nums == null || nums.length == 0) return 0;

        final int[] dp = new int[nums.length];
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,4,5,1,7,8,9};
        int result = lis(nums);
        System.out.println("Result : "+ result);
    }
}
