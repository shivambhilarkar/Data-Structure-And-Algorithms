package SlidingWindow;

import java.util.*;

public class DistinctElementsInWindow {

    public static List<Integer> distinctElementInWindow(int[] nums, int k){
        if(nums == null || nums.length < k) return Collections.emptyList();

        final List<Integer> result = new ArrayList<>();
        final Map<Integer,Integer> map = new HashMap<>();

        int left = 0;
        for(int right = 0; right < nums.length; right++){

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if(right >= k-1) {
                result.add(map.size());

                final int leftElement = nums[left];
                left += 1;
                if (map.get(leftElement) == 1) {
                    map.remove(leftElement);
                } else {
                    map.put(leftElement, map.get(leftElement) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){

    }

}
