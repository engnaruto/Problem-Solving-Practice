package leetcode.problems;

/*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
    Note:

    All given inputs are in lowercase letters a-z.
*/

public class _14_LongestCommonPrefix {


    /*
        Time: O(NM) M: Shortest string in the array
        Memory: O(M)
    */

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==0){
            return "";
        }

        StringBuilder builder = new StringBuilder();

        int min = Integer.MAX_VALUE;

        for (String s : strs) {
            min = Math.min(min, s.length());
        }

        boolean b = true;
        char c = ' ';
        for (int i = 0; i < min; i++) {
            c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != c) {
                    b = false;
                    break;
                }
            }

            if (!b) {
                break;
            }

            builder.append(c);
        }

        return builder.toString();
    }

    public static void main(String[] args){
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
        System.out.println("********");
        str = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(str));
        System.out.println("********");
    }
}
