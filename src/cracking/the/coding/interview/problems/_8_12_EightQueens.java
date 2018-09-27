package cracking.the.coding.interview.problems;


/*
    8.12
    Eight Queens: Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board
    so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all
    diagonals, not just the two that bisect the board.
*/


public class _8_12_EightQueens {

    public static int n = 8;

    public static boolean[][] board = new boolean[n][n];

    public static boolean[] rows = new boolean[n];
    public static boolean[] d1 = new boolean[n * 2 - 1];
    public static boolean[] d2 = new boolean[n * 2 - 1];
    public static int counter = 1;


    /*
        Time: O(???)
        Memory: O(N) Without considering the memory of the board.
    */

    public static void eightQueens(int c) {

        if (c == board.length) {

            System.out.println(counter++);
            System.out.println();
            for (boolean[] i : board) {
                for (boolean b : i) {
                    System.out.print((b ? 1 : 0) + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("***************");
            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            int d1Value = n - 1 - i + c;
            int d2Value = i + c;
            if (!rows[i] && !d1[d1Value] && !d2[d2Value]) {
                board[i][c] = true;
                rows[i] = true;
                d1[d1Value] = true;
                d2[d2Value] = true;
                eightQueens(c + 1);
                d1[d1Value] = false;
                d2[d2Value] = false;
                rows[i] = false;
                board[i][c] = false;
            }
        }
    }


    public static void main(String[] args) {
        eightQueens(0);
    }
}
