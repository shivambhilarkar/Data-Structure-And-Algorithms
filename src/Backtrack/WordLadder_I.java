package Backtrack;

import java.util.*;

public class WordLadder_I {

    /*
        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        Output: 5
        Explanation: One shortest transformation sequence is
        "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
     */


    public static int wordLadderLength(String startWord, String endWord, List<String> wordList) {
        if (startWord.equals(endWord)) return 0;

        Set<String> dictionary = new HashSet<>();
        dictionary.addAll(wordList);

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(startWord);
        int steps = 0;

        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return steps + 1;
                }
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] word = currentWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        word[j] = ch;
                        String newWord = new String(word);
                        if (dictionary.contains(newWord)) {
                            queue.add(newWord);
                            dictionary.remove(newWord);
                        }
                    }
                }
            }
            steps += 1;
        }
        //not possible -- to form word then return 0
        return 0;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        final int output = wordLadderLength(beginWord, endWord, wordList);
        System.out.println("Result : "+ output);
    }
}
