package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberLetterCombination {


    static class Phone {
        private final String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> getLetterCombination(String digits) {
            if (digits == null || digits.isEmpty()) return new ArrayList<>();

            List<String> result = new ArrayList<>();
            backtrack(digits, result, "");
            return result;
        }

        private void backtrack(String digits, List<String> result, String answer) {
            if (digits.isEmpty()) {
                result.add(new String(answer));
                return;
            }
            final char firstDigit = digits.charAt(0);
            final String restDigits = digits.substring(1);
            final String digitCode = codes[firstDigit - '0'];
            for (char code : digitCode.toCharArray()) {
                backtrack(restDigits, result, answer + code);
            }
        }
    }



    public static void main(String[] args) {

        String digits = "23";

        Phone phone = new Phone();
        List<String> result = phone.getLetterCombination(digits);
        System.out.println("Result : " + result);

    }
}
