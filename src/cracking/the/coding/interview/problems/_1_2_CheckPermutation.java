import java.util.*;

/*
    1.2
    Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    other.
*/

public class _1_2_CheckPermutation {
    /*
        Time: O(N)
        Space: O(1) Because the memory used for the array is constant
    */

    public static boolean checkPermutation(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] letters = new int[128];

        for (char c : str1.toCharArray()) {
            letters[c]++;
        }

        for (char c : str2.toCharArray()) {
            letters[c]--;
        }

        for (int i : letters) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /*
        Time: O(NLogN)
        Space: O(N)
    */

    public static boolean checkPermutationWithSorting(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;

    }

    /*
        Note: This code is more modulerer and shorter than the above
        Time: O(NLogN)
        Space: O(N)
    */

    public static String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }


    public static boolean checkPermutationWithSorting1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    public static void main(String[] args) {

        String[][] tests = {
                {"abcd", "abdc"},
                {"asd", "qwe"}
        };

        for (String[] test : tests) {
            System.out.println(checkPermutation(test[0], test[1]));
            System.out.println(checkPermutationWithSorting(test[0], test[1]));
            System.out.println(checkPermutationWithSorting1(test[0], test[1]));
        }
    }
}
