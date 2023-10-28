package PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static String reOrgnizeString(String input){
        if(input == null || input.isEmpty()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : input.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        queue.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Character,Integer> highestEntry = queue.poll();

            if(result.length() == 0 || highestEntry.getKey() != result.charAt(result.length() - 1)){
                result.append(highestEntry.getKey());
                highestEntry.setValue(highestEntry.getValue() - 1);
                if(highestEntry.getValue() != 0){
                    queue.add(highestEntry);
                }
            }else {
                Map.Entry<Character, Integer> secondHighestEntry = queue.poll();

                if (secondHighestEntry == null) return ""; //not possible.

                result.append(secondHighestEntry.getKey());
                secondHighestEntry.setValue(secondHighestEntry.getValue() - 1);
                if (secondHighestEntry.getValue() != 0) {
                    queue.add(secondHighestEntry);
                }
                queue.add(highestEntry);
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {

        String input = "shivambbhilarkar";

        String result = reOrgnizeString(input);
        System.out.println("Result : "+ result);
    }
}
