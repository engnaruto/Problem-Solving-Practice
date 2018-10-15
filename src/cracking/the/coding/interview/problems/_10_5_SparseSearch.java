package cracking.the.coding.interview.problems;


/*
    10.5
    Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a
    method to find the location of a given string.

    EXAMPLE

    Input: ball, {"at", "" , "" , "" , "ball", "" , "" , "car", "" , "" , "dad", "", ""}

    Output: 4
*/

public class _10_5_SparseSearch {

    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int sparseSearch(String[] arr, String target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end && arr[start].equals("")) {
            start++;
        }
        while (start <= end && arr[end].equals("")) {
            end--;
        }

        while (start <= end) {
            mid = (start + end) / 2;
//            System.out.println(start + " - " + mid + " - " + end);

            while (mid >= start && arr[mid].equals("")) {
                mid--;
            }

            if (mid < start) {
                return -1;
            }

            if (arr[mid].equals(target)) {
                return mid;
            } else if (arr[mid].equals("") || arr[mid].compareTo(target) > 0) {
                end = mid - 1;

                while (start <= end && arr[end].equals("")) {
                    end--;
                }
            } else {
                start = mid + 1;

                while (start <= end && arr[start].equals("")) {
                    start++;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] arr = {"", "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

        System.out.println(sparseSearch(arr, "at"));
    }
}
