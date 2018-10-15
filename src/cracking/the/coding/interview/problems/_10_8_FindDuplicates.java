package cracking.the.coding.interview.problems;


/*
    10.8
    Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32,000.
    The array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory
    available, how would you print all duplicate elements in the array?
*/

public class _10_8_FindDuplicates {

    public static class BitSet {
        int[] bitSet;

        BitSet(int size) {
            bitSet = new int[size / 32 + 1];
        }

        public void set(int i, boolean bool) {
            int index = i / 32;
            int mod = i % 32;

            if (bool) {
                bitSet[index] |= (1 << mod);
            } else {
                bitSet[index] &= ~(1 << mod);
            }
        }

        public boolean get(int i) {
            int index = i / 32;
            int mod = i % 32;

            return (bitSet[index] & (1 << mod)) != 0;
        }
    }


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static void findDuplicates(int arr[]) {

        BitSet bitset = new BitSet(32000);

        for (int i : arr) {
            int num = i - 1;
            if (bitset.get(num)) {
                System.out.println(i);
            } else {
                bitset.set(num, true);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {61, 1, 6006, 31, 32, 31, 32, 7, 7, 7, 3, 4, 8, 5, 2, 8, 2, 61, 1, 20, 2000, 6006, 2000, 32000, 32000};

        findDuplicates(arr);
    }
}
