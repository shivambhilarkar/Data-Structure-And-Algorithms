package SlidingWindow;

import java.util.HashMap;
import java.util.Map;


/**
 * Dynamic Size Window
 */
public class MinimumWindowSubString {

    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";

        //count word from window_string
        Map<Character, Integer> word = new HashMap<>();
        for (char ch : t.toCharArray()) {
            word.put(ch, word.getOrDefault(ch, 0) + 1);
        }

        String min_subString = "";
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int wordCount = word.size();
        int[] indices = new int[2];

        for (int right = 0; right < s.length(); right++) {

            //addition
            char currentChar = s.charAt(right);
            if (word.containsKey(currentChar)) {
                word.put(currentChar, word.get(currentChar) - 1);
                if (word.get(currentChar) == 0) {
                    wordCount -= 1;
                }
            }


            if (wordCount == 0) {
                //subtraction
                while (left <= right && wordCount == 0) {
                    int currentLength = right - left;
                    if (currentLength < minLength) {
                        minLength = currentLength;
                        indices = new int[]{left, right};
                    }

                    //increment left pointer
                    char prevChar = s.charAt(left);
                    if (word.containsKey(prevChar)) {
                        word.put(prevChar, word.get(prevChar) + 1);
                        if (word.get(prevChar) == 1) {
                            wordCount += 1;
                        }
                    }

                    left += 1;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(indices[0], indices[1] + 1);
    }

}
