package cracking.the.coding.interview.problems;

import java.util.ArrayList;

/*
    8.7
    Permutations without Dups: Write a method to compute all permutations of a string of unique
    characters.
*/


public class _8_7_PermutationsWithoutDups {


    public static ArrayList<String> result = new ArrayList<>();
    public static char[] cc;
    public static boolean[] visited;


    /*
        Time: O(N!)
        Memory: O(N!)
    */

    public static void permutationsWithoutDups(int i, char[] arr) {

        if (i >= arr.length) {
            result.add(new String(arr));
            return;
        }

        for (int j = 0; j < cc.length; j++) {
            if (!visited[j]) {
                arr[i] = cc[j];
                visited[j] = true;
                permutationsWithoutDups(i + 1, arr);
                visited[j] = false;
            }
        }
    }


    public static void main(String[] args) {
        String s = "abc";
        cc = s.toCharArray();
        visited = new boolean[cc.length];

        permutationsWithoutDups(0, new char[s.length()]);

        int count = 1;
        for (String ss : result) {
            System.out.println(count++ + "\t" + ss);
        }
    }
}
