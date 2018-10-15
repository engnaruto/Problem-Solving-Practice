package cracking.the.coding.interview.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/*
    10.2
    Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to
    each other.
*/

public class _10_2_GroupAnagrams {

    public static String sortString(String s) {

        char[] c = s.toCharArray();

        Arrays.sort(c);

        return new String(c);
    }


    /*
        Time: O(N * Log(N) * M * LOG(M)) M: Number of characters in a string
        Memory: O(1)
    */

    public static void groupAnagrams(String[] s) {
        Arrays.sort(s, (o1, o2) -> sortString(o2).compareTo(sortString(o1)));
    }


    /*
        Time: O(N * M * LOG(M)) M: Number of characters in a string
        Memory: O(N)
    */

    public static void groupAnagramsUsingHashMap(String[] s) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String ss : s) {

            String sorted = sortString(ss);

            if (!map.containsKey(sorted)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(ss);
                map.put(sorted, list);
            } else {
                map.get(sorted).add(ss);
            }
        }

        int index = 0;

        for (String key : map.keySet()) {
            for (String value : map.get(key)) {
                s[index++] = value;
            }
        }
    }


    public static void main(String[] args) {
        String[] s = {"acx", "axc", "bac", "bca", "xca"};

//        groupAnagrams(s);
        groupAnagramsUsingHashMap(s);

        System.out.println(Arrays.toString(s));
    }
}
