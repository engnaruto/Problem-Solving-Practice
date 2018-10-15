package sorting.implementations;

import java.util.Arrays;


public class SelectionSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


   /*
       Time: O(N ^ 2)
       Memory: O(1)
   */

    public static void selectionSort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 0, 2, 3, 5, 4};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
