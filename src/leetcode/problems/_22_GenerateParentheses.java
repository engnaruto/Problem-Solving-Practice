package leetcode.problems;


import java.util.ArrayList;
import java.util.List;

/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]

*/

public class _22_GenerateParentheses {

    /*
        Time: O(2 ^ N)
        Memory: O(N)
    */

    public static void generateParenthesis(int i, int j, String s, List<String> list) {

        if (i == 0 && j == 0) {
            list.add(s);
            return;
        }


        if (j >= i && i > 0) {
            generateParenthesis(i - 1, j, s + "(", list);
        }

        if (j >= i && j > 0) {
            generateParenthesis(i, j - 1, s + ")", list);
        }
    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, "", result);
        return result;
    }


    public static void main(String[] args) {

        List<String> list = generateParenthesis(2);

        list.forEach(s -> System.out.println(s));

        list = generateParenthesis(3);

        list.forEach(s -> System.out.println(s));

        list = generateParenthesis(0);

        list.forEach(s -> System.out.println(s));
    }
}
