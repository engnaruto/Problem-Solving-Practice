package cracking.the.coding.interview.problems;

import java.util.HashMap;
import java.util.HashSet;


/*
    8.8
    Permutations with Dups: Write a method to compute all permutations of a string whose characters
    are not necessarily unique. The list of permutations should not have duplicates.
*/

public class _8_8_PermutationsWithDups {
    public static HashSet<String> result = new HashSet<>();
    public static char[] cc;
    public static boolean visited[];


    /*
        Time: O(N!)
        Memory: O(N!)
    */
    public static void permutationsWithDups(int i, char[] arr) {

        if (i >= arr.length) {
            result.add(new String(arr));
            return;
        }

        for (int j = 0; j < cc.length; j++) {
            if (!visited[j]) {
                arr[i] = cc[j];
                visited[j] = true;
                permutationsWithDups(i + 1, arr);
                visited[j] = false;
            }
        }
    }


    public static HashMap<Character, Integer> map = new HashMap<>();


    /*
        Time: O(N!) This is the worst case if there is no duplicates but if the is a duplicates in the string, the order will be better than that
        Memory: O(N!)
    */

    public static void permutationsWithDupsUsingHashMap(String s) {

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        permutationsWithDupsUsingHashMap(s.length() - 1, new char[s.length()]);
    }


    public static void permutationsWithDupsUsingHashMap(int remaining, char[] arr) {

        if (remaining < 0) {
            result.add(new String(arr));
            return;
        }


        for (char c : map.keySet()) {

            arr[remaining] = c;
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
                permutationsWithDupsUsingHashMap(remaining - 1, arr);
                map.put(c, map.get(c) + 1);
            }
        }
    }


    public static void main(String[] args) {
        String s = "aba";
//        cc = s.toCharArray();
//        visited = new boolean[cc.length];
//        permutationsWithDups(0, new char[s.length()]);
        permutationsWithDupsUsingHashMap(s);
        int count = 1;
        for (String ss : result) {
            System.out.println(count++ + "\t" + ss);
        }
    }
}
