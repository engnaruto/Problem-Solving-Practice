package leetcode.problems;

import java.util.*;

/*
    Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
    If no such solution, return -1.

    For example, with A = "abcd" and B = "cdabcdab".

    Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring
    of A repeated two times ("abcdabcd").

    Note:
    The length of A and B will be between 1 and 10000.
*/

public class _686_RepeatedStringMatch {


    public static int repeatedStringMatch(String A, String B) {
        if(A.isEmpty()||B.isEmpty()){
            return -1;
        }

        int count = 1;

        StringBuilder builder = new StringBuilder(A);


        while (builder.length() < B.length()) {
            builder.append(A);
            count++;
        }

        if (builder.toString().contains(B)) {
            return count;
        }

        builder.append(A);
        count++;

        if (builder.toString().contains(B)) {
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";

        System.out.println(repeatedStringMatch(a, b));
    }
}


