
/*
    Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

    The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

    Example 1:
    Input: "UD"
    Output: true

    Example 2:
    Input: "LL"
    Output: false
*/
public class _657_JudgeRouteCircle {

    /*
         Time: O(N)
         Memory: O(1)
    */

    public static boolean judgeCircle(String moves) {

        int horizontalMovement = 0;
        int verticalMovement = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                horizontalMovement++;
            } else if (c == 'R') {
                horizontalMovement--;
            } else if (c == 'U') {
                verticalMovement++;
            } else {
                verticalMovement--;
            }
        }
        return (horizontalMovement == 0) && (verticalMovement == 0);
    }

    public static void main(String[] args) {
        String[] tests = {
                "UD",
                "LL",
                "ULDR",
                "ULDRR",
                "ULDRRL"
        };

        for (String test : tests) {
            System.out.println(judgeCircle(test));
        }
    }
}