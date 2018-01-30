
/*
    1.9
    String Rotation: Assume you have a method isSubstring which checks if one word is a substring
    of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
    call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
*/

public class _1_9_StringRotation {

    /*
        Time: O(N) without calculating the order of isSubstring() method (O(A + B))
        Memory: O(1) on the string level and O(N) on the characters level
    */

    public static boolean stringRotation(String original, String substring) {
        String original2 = original + original;
        return isSubstring(original2, substring);
    }

    public static boolean isSubstring(String original, String subString) {
        return original.contains(subString);
    }

    public static void main(String[] args) {

        String[][] tests = {
                {"waterbottle", "erbottlewat"},
                {"apple", "leapp"},
                {"hiixiii", "hiii"}
        };

        for (String[] test : tests) {
            System.out.println(stringRotation(test[0], test[1]));
        }
    }
}