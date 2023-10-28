package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 *  Dynamic Size Sliding Window
 */
public class LongestSubStringUniqueCharacters {


    public static int longestSubstring(String str){
        if(str == null || str.isEmpty()) return 0;

        final Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for(int right = 0; right < str.length(); right++){
            char current = str.charAt(right);
            map.put(current, map.getOrDefault(current, 0) + 1);

            if(map.get(current) > 1){
                while(map.get(current) > 1){
                    char leftChar = str.charAt(left);
                    if (map.get(leftChar) == 1){
                        map.remove(leftChar);
                    }else{
                        map.put(leftChar, map.get(leftChar) - 1);
                    }
                    left += 1;
                }
                result = Math.max(right - left + 1 , result);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
