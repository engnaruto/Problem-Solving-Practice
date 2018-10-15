package cracking.the.coding.interview.problems;


import java.util.ArrayList;


/*
    8.14
    Boolean Evaluation: Given a boolean expression consisting of the symbols 0 (false), 1 (true), &
    (AND), | (OR), and ^ (XOR), and a desired boolean result value result, implement a function to
    count the number of ways of parenthesizing the expression such that it evaluates to result. The
    expression should be fully parenthesized (e.g., (0)^(1)) but not extraneously (e.g., (((0))^(1))).

    EXAMPLE
    countEval("1 ^ 0 | 0 | 1", false) -> 2
    countEval("0 & 0 & 0 & 1 ^ 1 | 0", true) -> 10
*/

public class _8_14_BooleanEvaluation {

    public static char evaluate(char term1, char sign, char term2) {

        int t1 = Integer.valueOf(term1 + "");
        int t2 = Integer.valueOf(term2 + "");

        int result = 0;
        switch (sign) {
            case '|':
                result = t1 | t2;
                break;
            case '&':
                result = t1 & t2;
                break;
            case '^':
                result = t1 ^ t2;
        }

        String s = result + "";
        return s.charAt(0);
    }

    public static int counter = 1;

    /*
        Time: O()
        Memory: O()
        Note: This solution gives duplicates solution.

        Ex:

        (1 ^ 1) ^ 1 ^ 0
                        (0) ^ 1 ^ 0
                            ((0) ^ 1) ^ 0
                             (0) ^ (1 ^ 0)
         1 ^ 1 ^ (1 ^ 0)
                         1 ^ 1 ^ (1)
                            (1 ^ 1) ^ (1) = (0) ^ (1 ^ 0)
                             1 ^ (1 ^ (1))
        I need to know another solution instead of the complicated one in the book.
    */

    public static int booleanEvaluation(ArrayList<Character> expression, boolean target, int k) {
        System.out.println(expression.toString());
        if (expression.size() == 1) {
            if ((expression.get(0) == '0' && !target) || (expression.get(0) == '1' && target)) {
                System.out.println("===========================> " + counter++);
                return 1;
            }
            return 0;
        }

        int choose = 0;

        for (int i = 0; i < expression.size() - 1; i += 2) {
//            System.out.println(expression.size());
            char term1 = expression.remove(i);
            char sign = expression.remove(i);
            char term2 = expression.remove(i);
            char result = evaluate(term1, sign, term2);
            expression.add(i, result);
            choose += booleanEvaluation(expression, target, i);
            expression.remove(i);
            expression.add(i, term2);
            expression.add(i, sign);
            expression.add(i, term1);
        }

        return choose;
    }


    public static void main(String[] args) {
        char[] c = "0&0&0&1^1|0".toCharArray();
        boolean target = true;
//        char[] c = "1^0|0|1".toCharArray();
//        boolean target = false;
        ArrayList<Character> expression = new ArrayList<>();
        for (char cc : c) {
            expression.add(cc);
        }
        System.out.println(booleanEvaluation(expression, target, 0));
    }
}
