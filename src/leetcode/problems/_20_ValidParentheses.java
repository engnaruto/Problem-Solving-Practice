package leetcode.problems;


import java.util.Stack;

/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

    Example 1:

    Input: "()"

    Output: true

    Example 2:

    Input: "()[]{}"

    Output: true

    Example 3:

    Input: "(]"

    Output: false

    Example 4:

    Input: "([)]"

    Output: false

    Example 5:

    Input: "{[]}"

    Output: true
*/

public class _20_ValidParentheses {


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static boolean isValid(String s) {

        if (s.isEmpty()) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        int i = 0;

        while (true) {
            if (i == s.length()) {
                return stack.isEmpty();
            }

            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
            i++;
        }
    }


    public static void main(String[] args) {

        String s = "";
        System.out.println(isValid(s)); // true

        s = "()";
        System.out.println(isValid(s)); // true

        s = "()[]{}";
        System.out.println(isValid(s)); // true

        s = "(]";
        System.out.println(isValid(s)); // false

        s = "([)]";
        System.out.println(isValid(s)); // false

        s = "{[]}";
        System.out.println(isValid(s)); // true

        s = "{";
        System.out.println(isValid(s)); // false
    }
}
