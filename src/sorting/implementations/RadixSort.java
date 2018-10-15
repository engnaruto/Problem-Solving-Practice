package sorting.implementations;

import java.util.ArrayList;
import java.util.Arrays;


public class RadixSort {


    /*
        Time: O(KN) K: Number of bits in the biggest number.
        Memory: O(N)
    */

    public static void radixSort(int[] arr) {

        ArrayList<Integer>[] buckets = new ArrayList[2];

        int max = 0;

        for (int i : arr) {
            max = Math.max(max, i);
        }

        int length = Integer.toBinaryString(max).length();

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & (1 << i)) == 0) {
                    buckets[0].add(arr[j]);
                } else {
                    buckets[1].add(arr[j]);
                }
            }
            int index = 0;
            for (int j = 0; j < buckets.length; j++) {
                while (!buckets[j].isEmpty()) {
                    arr[index++] = buckets[j].remove(0);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 0, 2, 3, 5, 4};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
