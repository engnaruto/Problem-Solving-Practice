package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    Given an array of strings, group anagrams together.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],

    Output:

    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

    Note:

     - All inputs will be in lowercase.
     - The order of your output does not matter.
*/


public class _49_GroupAnagrams {


    public static String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    /*
        Time: O(N * M * Log(M))
        Memory: O(N)
    */

    public static List<List<String>> groupAnagrams(String[] strs) {


        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            String sorted = sortString(s);
            if (map.containsKey(sorted)) {
                List<String> list = map.get(sorted);
                list.add(s);
                map.put(sorted, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }


    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(strs);

        for (List<String> list : result) {
            System.out.println(list.toString());
        }
    }
}
