import java.util.*;

/*
    1.5
    One Away: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are
    one edit (or zero edits) away.
    EXAMPLE
    pale, ple -> true
    pales, pale -> true
    pale, bale -> true
    pale, bake -> false
*/

public class _1_5_OneWay {

    /*
        Time: O(N)
        Memory: O(1)
    */

    public static boolean oneWay(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return checkInserted(str1, str2);
        } else if (str1.length() > str2.length())
            return checkInserted(str2, str1);
        else {
            return checkUpdated(str1, str2);
        }
    }


    public static boolean checkInserted(String str1, String str2) {

        boolean isInserted = false;
        int i = 0;
        int j = 0;

        while (i < str1.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (!isInserted) {
                    isInserted = true;
                    j++;
                } else {
                    return false;
                }
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static boolean checkUpdated(String str1, String str2) {
        boolean isUpdated = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (!isUpdated) {
                    isUpdated = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[][] tests = {
                {"pale", "ple"},
                {"pales", "pale"},
                {"pale", "bale"},
                {"pale", "bake"}
        };

        for (String[] test : tests) {
            System.out.println(oneWay(test[0], test[1]));
        }
    }
}
