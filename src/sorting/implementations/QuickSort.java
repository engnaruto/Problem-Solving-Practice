package sorting.implementations;

import java.util.Arrays;


public class QuickSort {

    public static int[] arr;

    /*
       Time: O(N * Log(N)) average case, O(N ^ 2) worst case
       Memory: O(Log(N))
    */

    public static void quickSort(int start, int end) {

        int index = partition(start, end);

        if (start < index - 1) {
            quickSort(start, index - 1);
        }

        if (index < end) {
            quickSort(index, end);
        }
    }


    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private static int partition(int start, int end) {

        int pivot = (start + end) / 2;
        while (start <= end) {
            while (arr[start] < arr[pivot]) {
                start++;
            }

            while (arr[pivot] < arr[end]) {
                end--;
            }

            if (start <= end) {
                swap(start, end);
                start++;
                end--;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        arr = new int[]{6, 1, 0, 2, 3, 25, 10, 5, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
