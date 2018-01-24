import java.util.*;

/*
    1.1
    Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    cannot use additional data structures?
*/

public class _1_1_IsUnique {

    /*
        Time: O(N)
        Space: O(1) Because 128 is a constant number and the string can be more than 128 (number of characters in ASCII)
    */

    public static HashSet<Character> hs = new HashSet<>();

    public static boolean isUnique(String str) {
        for (char c : str.toCharArray()) {
            if (hs.contains(c)) {
                return false;
            } else {
                hs.add(c);
            }
        }
        return true;
    }

    /*
        Time: O(N)
        Space: O(1) Because 128 is a constant number and the string can be more than 128 (number of characters in ASCII)
    */

    public static boolean isUniqueWithArrays(String str) {
        boolean[] arr = new boolean[128];

        for (char c : str.toCharArray()) {
            if (arr[c]) {
                return false;
            } else {
                arr[c] = true;
            }
        }
        return true;
    }

    /*
        Note: This solution assumes that all characters of the string are lowercase
        Time: O(N)
        Space: O(1) Because 128 is a constant number and the string can be more than 128 (number of characters in ASCII)
    */

    public static boolean isUniqueWithBits(String str) {
        int bitmap = 0;

        for (char c : str.toCharArray()) {
            int position = c - 'a';
            if ((bitmap & (1 << position)) == 1) {
                return false;
            } else {
                bitmap |= (1 << position);
            }
        }
        return true;
    }

    /*
        Time: O(N^2)
        Space: O(1)
    */

    public static boolean isUniqueWihoutDataStructures(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }


    /*
        Time: O(NLog(N))
        Space: O(1)
    */
    public static boolean isUniqueWihSorting(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] tests = {"abcdef", "abcdefa"};

        for (String test : tests) {
            System.out.println(isUnique(test));
            System.out.println(isUniqueWihoutDataStructures(test));
            System.out.println(isUniqueWithArrays(test));
            System.out.println(isUniqueWithBits(test));
        }
    }

}
