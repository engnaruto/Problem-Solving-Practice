package cracking.the.coding.interview.problems;


/*
    5.7
    Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as
    possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
*/

public class _5_7_PairwiseSwap {

    public static int pairwiseSwap(int n) {

        int left = n << 1;
        int right = n >> 1;
        int number = 0;
        for (int i = 0; i < Integer.toBinaryString(left).length(); i++) {
            if (i % 2 == 0) {
                if ((right & (1 << i)) != 0) {
                    number |= 1 << i;
                }
            } else {
                if ((left & (1 << i)) != 0) {
                    number |= 1 << i;
                }
            }
        }
        return number;
    }

    public static int pairwiseSwapUsingMasks(int n) {

        int left = n;
        int right = n;
        int number = 0;

        left &= 0xaaaaaaaa;
        right &= (0xaaaaaaaa >> 1);
        number = (left >>> 1) | (right << 1);


        return number;
    }

    public static void main(String[] args) {
        int n = Integer.valueOf("1101011101", 2);
        System.out.println(Integer.toBinaryString(pairwiseSwap(n)));
        System.out.println(Integer.toBinaryString(pairwiseSwapUsingMasks(n)));
//        System.out.println("1110101110");
    }
}
