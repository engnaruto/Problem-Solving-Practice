package cracking.the.coding.interview.problems;


/*
    8.5
    Recursive Multiply: Write a recursive function to multiply two positive integers without using
    the * operator (or / operator). You can use addition, subtraction, and bit shifting, but you should
    minimize the number of those operations.
*/

public class _8_5_RecursiveMultiply {

    /*
        Time: O(Log(N))
        Memory: O(Log(N))
    */

    public static int recursiveMultiply(int x, int y) {

        int smaller = x > y ? y : x;
        int bigger = x > y ? x : y;

        return multiply(bigger, smaller);
    }

    public static int multiply(int x, int y) {

        if (y == 0) {
            return 0;
        } else if (y == 1) {
            return x;
        }

        int part1 = y >> 1;
        int part2 = y - part1;

        part1 = part2 > part1 ? part1 : part2;

        int result = multiply(x, part1);

        if (y % 2 == 0) {
            return result + result;
        } else {
            return result + result + x;
        }
    }


    public static void main(String[] args) {

        int x = 7;
        int y = 30;

        System.out.println(recursiveMultiply(x, y));
    }
}
