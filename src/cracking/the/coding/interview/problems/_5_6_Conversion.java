package cracking.the.coding.interview.problems;

/*
    5.6
    Conversion: Write a function to determine the number of bits you would need to flip to convert
    integer A to integer B.
    EXAMPLE
    Input: 29 (or: 111101), 15 (or: 101111)
    Output: 2
*/

public class _5_6_Conversion {

    public static int conversion(int i, int j) {
        int x = i ^ j;
        System.out.println(Integer.toBinaryString(x));
        int counter = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                counter++;
            }
            x >>>= 1;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(conversion(29, -1));

    }
}
