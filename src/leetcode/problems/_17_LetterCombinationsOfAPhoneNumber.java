package leetcode.problems;


import java.util.ArrayList;
import java.util.List;

/*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations
    that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.

    Example:

    Input: "23"

    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    Note:
        Although the above answer is in lexicographical order, your answer could be in any order you want.
*/


public class _17_LetterCombinationsOfAPhoneNumber {

    public static ArrayList<String> result;

    public static void getList(ArrayList<String> list, String[] chars, String digits, int index, int charIndex, StringBuilder builder) {

        if (index >= digits.length()) {
            String s = builder.toString();
            list.add(s);
            return;
        }


        int number = digits.charAt(index)-'2';
        String str = chars[number];

        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            getList(list, chars, digits, index + 1, charIndex + 1, builder);
//            System.out.println(builder.toString());
            builder.deleteCharAt(charIndex);
        }
    }


    public static List<String> letterCombinations(String digits) {

        String[] chars = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> result = new ArrayList<>();

        getList(result, chars, digits, 0, 0, new StringBuilder());

        return result;
    }


    public static void main(String[] args) {

        System.out.println(letterCombinations("222").toString());
    }
}
