package Backtrack;

import java.util.*;

public class WordBreak {

    public static List<String> getWords(String str, List<String> wordList) {
        if (str == null || str.isEmpty()) return Collections.emptyList();

        Set<String> dictionary = new HashSet<>();
        dictionary.addAll(wordList);
        List<String> result = new ArrayList<>();
        List<String> combination = new ArrayList<>();

        backtrack(str, 0, dictionary, result, combination);
        return result;
    }

    private static void backtrack(String str, int left, Set<String> dictionary, List<String> result, List<String> temp) {
        if (left == str.length()) {
            String newString = String.join("", temp);
            result.add(newString);
        }

        for (int right = left + 1; right <= str.length(); right++) {
            String substring = str.substring(left, right);
            if (dictionary.contains(substring)) {
                temp.add(substring);
                backtrack(str, right, dictionary, result, temp);
                temp.remove(temp.size() - 1);
            }
        }

    }


    public static void main(String[] args) {

    }


}
