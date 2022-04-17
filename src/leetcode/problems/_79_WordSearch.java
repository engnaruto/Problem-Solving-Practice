package leetcode.problems;


/*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells
    are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

    Example:

    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]

    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
*/

public class _79_WordSearch {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index >= word.length()) {
            return true;
        } else if (word.charAt(index) != board[i][j]) {
            return false;
        }

        boolean found = false;
        int x, y;

        for (int k = 0; k < dx.length; k++) {
            x = i + dx[k];
            y = j + dy[k];

            if (checkBoarders(board, x, y)) {
                char c = board[i][j];
                board[i][j] = '0';
                found |= dfs(board, word, x, y, index + 1);
                board[i][j] = c;
            }
        }
        return found;
    }


    private static boolean checkBoarders(char[][] board, int i, int j) {
        return !(i >= board.length || i < 0 || j >= board[0].length || j < 0);
    }


    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
        System.out.println(exist(board, "EED"));
        System.out.println(exist(board, "FCCS"));
        System.out.println(exist(board, ""));
    }
}
