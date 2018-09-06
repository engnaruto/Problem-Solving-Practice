
/*
    5.1
    Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
    j. Write a method to insert M into N such that M starts at bit j and ends at bit i. 
    You can assume that the bits j through i have enough space to fit all of M. That is, 
    if M = 10011, you can assume that there are at least 5 bits between j and i. 
    You would not, for example, have j = 3 and i = 2, because M could not fully fit 
    between bit 3 and bit 2.

    EXAMPLE

    Input:  N = 10000000000, M = 10011, i = 2, j = 6

    Output: N = 10001001100
*/

public class _5_1_Insertion {

    /*
        The book's solution is simpler
    */

    /*
        Time: O(b(N)) number of bits in N
        Memory: O(1)
    */

    public static int insertion(int n, int m, int i, int j) {

        int interval = j - i + 1;
        int countM = 0;
        int mm = m;

        while (mm != 0) {
            countM++;
            mm = mm >> 1;
        }

        if (interval < countM) {
            System.out.println(interval + " - " + countM);
            return -1;
        } else {
            int mask = 0;
            mask = ~((1 << (j + 1)) - 1);
            mask = mask | ((1 << i + 1) - 1);
            n &= mask;
            n |= m << i;
            return n;
        }
    }

    public static void main(String[] args) {

        System.out.println(Integer
                .toBinaryString(insertion(Integer.valueOf("10000000000", 2), Integer.valueOf("10011", 2), 2, 6)));
    }

}
