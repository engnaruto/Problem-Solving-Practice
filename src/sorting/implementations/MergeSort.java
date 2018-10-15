package sorting.implementations;

import java.util.Arrays;


public class MergeSort {

    public static int[] arr;


    /*
        Time: O(N * Log(N))
        Memory: O(N)
    */

    public static void mergeSort(int first, int last, int[] helper) {
        if (first < last) {
            int mid = (first + last) / 2;

//            System.out.println(first + " - " + last);

            mergeSort(first, mid, helper);
            mergeSort(mid + 1, last, helper);
            merge(first, mid, last, helper);
        }
    }

    public static void merge(int first, int mid, int last, int[] helper) {

        for (int i = first; i <= last; i++) {
            helper[i] = arr[i];
        }

        int index = first;

        int i = first;
        int j = mid + 1;

        while (i < mid + 1 && j <= last) {
            if (helper[i] < helper[j]) {
                arr[index++] = helper[i++];
            } else {
                arr[index++] = helper[j++];
            }
        }

        for (; i < mid + 1; i++) {
            arr[index++] = helper[i];
        }

        for (; j <= last; j++) {
            arr[index++] = helper[j];
        }
    }


    public static void main(String[] args) {
        arr = new int[]{6, 1, 0, 2, 3, 5, 4};
        System.out.println(Arrays.toString(arr));
        int[] helper = new int[arr.length];
        mergeSort(0, arr.length - 1, helper);
        System.out.println(Arrays.toString(arr));
    }
}
