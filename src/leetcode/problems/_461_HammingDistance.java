
/*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, calculate the Hamming distance.

    Note:
    0 ≤ x, y < 231.

    Example:

    Input: x = 1, y = 4

    Output: 2

    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑

    The above arrows point to positions where the corresponding bits are different.
*/

public class _461_HammingDistance {

    /*
        Note: You can use Integer.bitCount(x ^ y) to get the solution in one line.
        Time: O(N) => N bits <= 32 (integer)
        Memory: O(1)
    */

    public static int hammingDistance(int x, int y) {

        int xor = x ^ y;

        int count = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                count++;
            }
            xor >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, 4},
                {7, 1},
                {15, 4},
                {5, 2}
        };

        for (int[] test : tests) {
            System.out.println(hammingDistance(test[0], test[1]));
        }
    }
}
