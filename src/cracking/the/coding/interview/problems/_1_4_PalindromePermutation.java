package cracking.the.coding.interview.problems;


/*
    1.4
    Palindrome Permutation: Given a string, write a function to check if it is a permutation of
    a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
    permutation is a rearrangement of letters. The palindrome does not need to be limited to just
    dictionary words.
    EXAMPLE
    Input: Tact Coa
    Output: True (permutations: "taco cat", "atco eta", etc.)
*/

public class _1_4_PalindromePermutation {

    /*
        Time: O(N)
        Space: O(1)
    */

    public static boolean palindromePermutation(String str) {
        int[] letters = new int[128];
        boolean hasMoreThanOneOddCharacter = false;
        for (char c : str.toCharArray()) {
            letters[c]++;
        }
        for (int i : letters) {
            if (i % 2 != 0) {
                if (!hasMoreThanOneOddCharacter) {
                    hasMoreThanOneOddCharacter = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /*
        Time: O(N)
        Space: O(1) Replace the array by a bitmask.
    */

    public static int createBitVector(String str) {
        int mask = 0;
        int index = 0;
        for (char c : str.toCharArray()) {
            if (c >= 'A') {
                index = c - 'A';
            }
            mask = toggle(mask, index);
        }
        return mask;
    }

    public static int toggle(int mask, int index) {
        int bitIndex = 1 << index;
        if ((mask & bitIndex) == 0) {
            mask |= bitIndex;
        } else {
            mask &= ~bitIndex;
        }
        return mask;
    }

    public static boolean palindromePermutationWithBits(String str) {
        int mask = createBitVector(str);
        return (mask & (mask - 1)) == 0;
    }


    public static void main(String[] args) {
        String[] tests = {"abcdbca", "aa", "aaa", "abbbaa", "abc"};

        for (String test : tests) {
            System.out.println(palindromePermutation(test));
            System.out.println(palindromePermutationWithBits(test));
        }
    }
}
