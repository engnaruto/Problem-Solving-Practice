package cracking.the.coding.interview.problems;


/*
    8.3
    Magic Index: A magic index in an array A [e ... n -1] is defined to be an index such that A[i] = i.
    Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
    array A.
    FOLLOW UP
    What if the values are not distinct?
*/

public class _8_3_MagicIndex {

    /*
        Time: O(Log(N))
        Memory: O(1)
    */

    public static int magicIndex(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (end - start >= 0) {
            mid = (start + end) / 2;
            if (mid > arr[mid]) {
                start = mid + 1;
            } else if (mid < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /*
        Time: O(Log(N)) It is > O(Log) and < O(N)
        Memory: O(Log(N))
    */

    public static int magicIndexForNotUniqueNumbers(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int num = -1;

        if (end - start >= 0) {
            if (mid > arr[mid]) {
                num = magicIndexForNotUniqueNumbers(arr, mid + 1, end);
                if (num == -1) {
                    int index = Math.min(mid - 1, arr[mid]);
                    num = magicIndexForNotUniqueNumbers(arr, start, index);
                }
            } else if (mid < arr[mid]) {
                num = magicIndexForNotUniqueNumbers(arr, start, mid - 1);
                if (num == -1) {
                    int index = Math.max(mid + 1, arr[mid]);
                    num = magicIndexForNotUniqueNumbers(arr, index, end);
                }
            } else {
                return mid;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 3, 5, 6, 7, 8, 9, 10};
        System.out.println(magicIndex(arr));

        arr = new int[]{0, 0, 1, 2, 5, 6, 7, 8, 9, 10};
        System.out.println(magicIndexForNotUniqueNumbers(arr, 0, arr.length - 1));
    }
}
