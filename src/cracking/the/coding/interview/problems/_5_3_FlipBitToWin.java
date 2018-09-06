
import java.util.ArrayList;

/*
    5.3
    Flip Bit to Win: You have an integer and you can flip exactly one bit from a O to a 1. Write code to
    find the length of the longest sequence of 1 s you could create.
    EXAMPLE
    Input: 1775 (or: 11011101111)
    Output: 8
*/

public class _5_3_FlipBitToWin {


    public static class Pair {
        int x, y;

        Pair(int i, int j) {
            x = i;
            y = j;
        }

        @Override
        public String toString() {
            return "(" + x + " - " + y + ")";
        }
    }


    /*
        Time: O(b), b: Number of bits
        Memory: O(S), S: Number of segments of 0s and 1s in N
    */

    public static int flipBitToWin(int n) {
        ArrayList<Pair> list = new ArrayList<>();
        int type = -1;
        while (n != 0) {
            int i = n & 1;

            if (type != i) {
                list.add(new Pair(i, 1));
                type = i;
            } else {
                list.get(list.size() - 1).y++;
            }
            n >>= 1;
        }

//        System.out.println(list.toString());

        int maxISequence = 0;
        int concatSequences = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x == 1 && list.get(i).y > maxISequence) {
                maxISequence = list.get(i).y;
            } else if (list.get(i).x == 0 && list.get(i).y == 1) {
                if (i == 0 && list.size() > 1) {
                    concatSequences += list.get(i + 1).y;
                } else {
                    concatSequences = Math.max(concatSequences, list.get(i - 1).y + list.get(i + 1).y + 1);
                }
            }
        }
        if (concatSequences < maxISequence) {
            concatSequences = maxISequence + 1;
        }
        return concatSequences;
    }


    /*
        Time: O(b), b: Number of bits
        Memory: O(1)
    */

    public static int flipBitToWinBestSolution(int n) {
        int previousSequence = 0;
        int currentSequence = 0;
        int maxSequence = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                currentSequence++;
            } else {
                if (((n >> 1) & 1) == 0) {
                    maxSequence = Math.max(maxSequence, currentSequence + 1);
                    previousSequence = 0;
                } else {
                    previousSequence = currentSequence;
                }
                currentSequence = 0;
            }
            maxSequence = Math.max(maxSequence, previousSequence + 1 + currentSequence);
            n >>= 1;
        }
        return maxSequence;
    }

    public static void main(String[] args) {
        System.out.println(flipBitToWin(Integer.valueOf("11011101111", 2)));
        System.out.println(flipBitToWinBestSolution(Integer.valueOf("11011101111", 2)));
    }
}
