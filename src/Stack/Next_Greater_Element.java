package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Next_Greater_Element {


    /*
        Input: nums = [1,2,3,4,3]
        Output: [2,3,4,-1,4]
     */
    public static int[] nextGreaterElement(int[] nums){
        if(nums == null || nums.length == 0) return new int[]{};

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        ArrayDeque<Integer> indexStack = new ArrayDeque<>();
        for(int index = 0; index < nums.length; index++){

            while(!indexStack.isEmpty() && nums[indexStack.peek()] <= nums[index]){
                result[indexStack.pop()] = nums[index];
            }
            indexStack.push(index);
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = { 1,2,3,4,3};
        int[] result = nextGreaterElement(nums);
        System.out.println("Result : "+ Arrays.toString(result));
    }
}
