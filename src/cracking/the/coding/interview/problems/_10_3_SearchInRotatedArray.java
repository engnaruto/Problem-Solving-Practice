package cracking.the.coding.interview.problems;


/*
    10.3
    Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
    number of times, write code to find an element in the array. You may assume that the array was
    originally sorted in increasing order.

    EXAMPLE

    Input:find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}

    Output: 8 (the index of 5 in the array)
*/

public class _10_3_SearchInRotatedArray {

    /*
        Time: O(Log(N)) Can reach to O(N) if there are duplicates in the array
        Memory: O(Log(N))
    */

    public static int searchInRotatedArray(int[] arr, int start, int end, int target) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

//        System.out.println(arr[start] + " - " + arr[mid] + " - " + arr[end]);
        if (arr[mid] == target) {
//            System.out.println("Mid");
            return mid;
        } else if (arr[start] < arr[mid]) {
            if (arr[start] <= target && target < arr[mid]) {
                return searchInRotatedArray(arr, start, mid - 1, target);
            } else {
                return searchInRotatedArray(arr, mid + 1, end, target);
            }
        } else if (arr[mid] < arr[end]) {
            if (arr[mid] < target && target < arr[end]) {
                return searchInRotatedArray(arr, mid + 1, end, target);
            } else {
                return searchInRotatedArray(arr, start, mid - 1, target);
            }
        } else if (arr[start] == arr[mid]) {
            return searchInRotatedArray(arr, mid + 1, end, target);

        } else {
            return searchInRotatedArray(arr, start, mid - 1, target);
        }
    }


    public static void main(String[] args) {

//        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] arr = {2, 2, 2, 3, 4, 2};
        System.out.println(searchInRotatedArray(arr, 0, arr.length - 1, 2));
    }
}
