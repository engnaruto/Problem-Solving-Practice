package cracking.the.coding.interview.problems;


import java.util.Arrays;


/*
    10.1
    Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
    end to hold B. Write a method to merge B into A in sorted order.
*/

public class _10_1_SortedMerge {


    /*
        Time: O(A + B)
        Memory: O(1)
    */

    public static void sortedMerge(int[] a, int[] b) {

        int index = a.length - 1;
        int i = a.length - b.length - 1;
        int j = b.length - 1;

        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[index--] = a[i--];
            } else {
                a[index--] = b[j--];
            }
        }

        while (j >= 0) {
            a[index--] = b[j--];
        }
    }


    public static void main(String[] args) {
        int[] a = {0, 2, 4, 6, 8, 10, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 3, 5, 7, 9, 11};

        sortedMerge(a, b);

        System.out.println(Arrays.toString(a));
    }
}
