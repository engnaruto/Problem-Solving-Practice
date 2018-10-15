package cracking.the.coding.interview.problems;


/*
    10.4
    Sorted Search, No Size: You are given an array-like data structure Listy which lacks a size method.
    It does, however, have an elementAt (i) method that returns the element at index i in 0(1) time.
    If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
    structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
    find the index at which an element x occurs. If x occurs multiple times, you may return any index.
*/

public class _10_4_SortedSearchNoSize {

    public static class Listy {
        private int[] list;

        Listy(int[] arr) {
            list = arr;
        }

        public int elementAt(int i) {

            if (i >= list.length) {
                return -1;
            }
            return list[i];
        }
    }


    /*
        Time: O(Log(N))
        Memory: O(1)
    */

    public static int sortedSearchNoSize(Listy list, int target) {
        if (list.elementAt(0) > target) {
            return -1;
        }

        int index = 1;
        while (list.elementAt(index) < target && list.elementAt(index) != -1) {
            index *= 2;
        }

        if (list.elementAt(index) == target) {
            return index;
        } else {
            int start = index / 2 + 1;
            int end = index - 1;
            int mid;

            while (start <= end) {
                mid = (start + end) / 2;

                if (list.elementAt(mid) == target) {
                    return mid;
                } else if (list.elementAt(mid) == -1 || list.elementAt(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 12, 12, 14, 20, 25, 30};

        Listy list = new Listy(arr);

        System.out.println(sortedSearchNoSize(list, 12));
    }
}
