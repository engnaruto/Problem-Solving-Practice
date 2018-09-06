package cracking.the.coding.interview.problems;



/*
    5.4
    Next Number: Given a positive integer, print the next smallest and the next largest number that
    have the same number of 1 bits in their binary representation.
*/

public class _5_4_NextNumber {


    /*
        Time: O(b), b: Number of bits
        Memory: O(1)
    */
    public static void nextNumber(int n) {
        int biggest = -1;
        int smallest = -1;

        System.out.println(n + " - " + Integer.toBinaryString(n));

        for (int i = 0; i < 31; i++) {
            if ((((1 << i) & n) == 0) && ((1 << ((i + 1)) & n) != 0) && smallest == -1) {
            System.out.println(i);

                int counter = 0;
                for (int j = 0; j < i; j++) {
                    if ((n & (1 << j)) != 0) {
                        counter++;
                    }
                }

                smallest = n & (~(1 << (i + 1)));
                smallest |= (1 << i + 1) - 1;

                smallest &= ~((1 << i - counter) - 1);

            } else if (((1 << i) & n) != 0 && ((1 << (i + 1)) & n) == 0 && biggest == -1) {
                int counter = 0;
                for (int j = 0; j < i; j++) {
                    if ((n & (1 << j)) != 0) {
                        counter++;
                    }
                }

                biggest = n & (~(1 << i)); // 101011000, i = 4 => 1010(0)1000
                biggest |= (1 << (i + 1)); // 101001000 => 101(1)01000

                biggest &= ~((1 << (i + 1)) - 1); // 101101000 => 1011(00000)
                biggest |= ((1 << counter) - 1); // 10110000 => 1011000(1)
            }
            if (biggest != -1 && smallest != -1) {
                break;
            }
        }
        System.out.println("Biggest: " + (biggest != -1 ? biggest : "ERROR") + " - " + Integer.toBinaryString(biggest));
        System.out.println("Smallest: " + (smallest != -1 ? smallest : "ERROR") + " - " + Integer.toBinaryString(smallest));

    }

    public static void main(String[] args) {
        int n = Integer.valueOf("101101011", 2);
        nextNumber(n);
    }
}
