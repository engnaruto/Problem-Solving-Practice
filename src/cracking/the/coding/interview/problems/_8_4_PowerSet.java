package cracking.the.coding.interview.problems;

import java.util.ArrayList;


/*
    8.4
    Power Set: Write a method to return all subsets of a set.
*/

public class _8_4_PowerSet {

    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static int[] arr;


   /*
       Time: O(N * (2 ^ N))
       Memory: O(2 ^ N)
   */

    public static void powerSet() {

        for (int i = 0; i <= arr.length; i++) {
            backTracking(new ArrayList<>(), 0, i);
        }
    }

    private static void backTracking(ArrayList<Integer> list, int i, int target) {

        if (target == 0) {
            ArrayList<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            result.add(copy);
            return;
        } else if (i >= arr.length) {
            return;
        }

        list.add(arr[i]);
        backTracking(list, i + 1, target - 1);
        list.remove(list.size() - 1);
        backTracking(list, i + 1, target);
    }


    public static void main(String[] args) {

        arr = new int[]{1, 2, 3, 4, 5};
        powerSet();
        for (ArrayList<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
