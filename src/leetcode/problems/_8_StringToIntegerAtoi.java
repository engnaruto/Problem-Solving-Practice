
/*
    Implement atoi which converts a string to an integer.

    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
    Then, starting from this character, takes an optional initial plus or minus sign
    followed by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have
    no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
    exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

    Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within
    the 32-bit signed integer range: [−2 ^ 31,  2 ^ 31 − 1]. If the numerical value is out of the range of representable values,
    INT_MAX (2 ^ 31 − 1) or INT_MIN (−2 ^ 31) is returned.

    Example 1:

    Input: "42"

    Output: 42

    Example 2:

    Input: "   -42"

    Output: -42

    Explanation: The first non-whitespace character is '-', which is the minus sign.
                 Then take as many numerical digits as possible, which gets 42.

    Example 3:

    Input: "4193 with words"

    Output: 4193

    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

    Example 4:

    Input: "words and 987"

    Output: 0

    Explanation: The first non-whitespace character is 'w', which is not a numerical
                 digit or a +/- sign. Therefore no valid conversion could be performed.
    Example 5:

    Input: "-91283472332"

    Output: -2147483648

    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
                 The fore INT_MIN (−231) is returned.
*/

public class _8_StringToIntegerAtoi {

     /*
        Time: O(N) N: Number of characters in the string
        Memory: O(1)
    */

    public static int myAtoi(String str) {
        if (str.isEmpty() || !Character.isDigit(str.charAt(0)) && str.charAt(0) != '+' && str.charAt(0) != '-' && str.charAt(0) != ' ') {
            return 0;
        }

        StringBuilder builder = new StringBuilder();

        boolean isSpacesFinished = false;
        boolean isFirstChar = true;

        for (char c : str.toCharArray()) {

            if (c == ' ' && !isSpacesFinished) {
                continue;
            } else if ((c == ' ' && isSpacesFinished) || !Character.isDigit(c)) {
                if ((c == '-' || c == '+') && isFirstChar) {
                    builder.append(c);
                    isSpacesFinished = true;
                } else {
                    break;
                }
            } else {
                builder.append(c);
                isSpacesFinished = true;
            }
            isFirstChar = false;
        }

        String num = builder.toString();

        if (num.isEmpty() || (num.length() == 1 && !Character.isDigit(num.charAt(0)))) {
            return 0;
        }

        long sum = 0;
        boolean hasSign = false;

        if (!Character.isDigit(num.charAt(0))) {
            if (num.charAt(0) == '-') {
                hasSign = true;
            }
            num = num.substring(1);
        }

        for (int i = 0; i < num.length(); i++) {
            sum += (num.charAt(i) - '0') * Math.pow(10, num.length() - 1 - i);

            if (sum > Integer.MAX_VALUE) {
                return hasSign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return hasSign ? (int) sum * -1 : (int) sum;
    }


    /*
        Time: O(N) N: Number of characters in the string
        Memory: O(1)
    */

    public static int myAtoi2(String str) {

        if (str.isEmpty()) {
            return 0;
        }


        int index = 0;


        while (index < str.length()) {
            if (str.charAt(index) == ' ') {
                index++;
            } else {
                break;
            }
        }

        int sign = 1;

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            if (str.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }

        long sum = 0;

        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                sum = sum * 10 + (str.charAt(index) - '0');
                index++;
                if (sum > Integer.MAX_VALUE) {
                    return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }


        return sign * (int) sum;
    }


    public static void main(String[] args) {

        String s = " +42";

        System.out.println(myAtoi2(s));
    }

}