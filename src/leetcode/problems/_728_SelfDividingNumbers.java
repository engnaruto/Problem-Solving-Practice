import java.util.*;

/*
    A self-dividing number is a number that is divisible by every digit it contains.

    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

    Also, a self-dividing number is not allowed to contain the digit zero.

    Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

    Example 1:
    Input:
    left = 1, right = 22
    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

    Note:
    The boundaries of each input argument are 1 <= left <= right <= 10000.
*/

public class _728_SelfDividingNumbers {

    /*
        Note: Time: O(NLog(R)) N: Length of the interval,  Log(R): Number of digits of longest number in the interval (Last number in the interval)
        Time: O(NM) Length of the interval * number of digits of longest number in the interval
        Memory: O(N) Length of the interval
    */

    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();

        int currentNum = 0;
        int currentDigit = 0;
        boolean isSelfDividingNumber = true;

        for (int i = left; i <= right; i++) {
            currentNum = i;
            isSelfDividingNumber = true;
            while (currentNum != 0) {
                currentDigit = currentNum % 10;
                if (currentDigit == 0 || i % currentDigit != 0) {
                    isSelfDividingNumber = false;
                    break;
                }
                currentNum /= 10;
            }

            if (isSelfDividingNumber) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int[][] tests = {
                {1, 22},
                {150, 170}
        };

        for (int[] test : tests) {
            System.out.println(selfDividingNumbers(test[0], test[1]));
        }
    }
}
