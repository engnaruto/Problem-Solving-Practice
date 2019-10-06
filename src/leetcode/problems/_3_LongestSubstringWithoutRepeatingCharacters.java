package leetcode.problems;


/*
    Given a string, find the length of the longest substring without repeating characters.

    Example 1:

    Input: "abcabcbb"

    Output: 3

    Explanation: The answer is "abc", with the length of 3.

    Example 2:

    Input: "bbbbb"

    Output: 1

    Explanation: The answer is "b", with the length of 1.

    Example 3:

    Input: "pwwkew"

    Output: 3

    Explanation: The answer is "wke", with the length of 3.
                 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.HashMap;
import java.util.HashSet;

public class _3_LongestSubstringWithoutRepeatingCharacters {


    /*
        Time: O(N ^ 3)
        Memory: O(1) Because we have a limited number of characters in the alphabet
    */

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();

        boolean haveDuplicateCharacters = false;
        boolean windowChecked = false;
        int k = s.length();
        for (; k > 1; k--) {
            for (int i = 0; i < s.length(); i++) {
                haveDuplicateCharacters = false;
                windowChecked = false;
                set.clear();
                for (int j = i; j < i + k && i + k <= s.length(); j++) {
                    windowChecked = true;
                    if (set.contains(s.charAt(j))) {
                        haveDuplicateCharacters = true;
                        break;
                    } else {
                        set.add(s.charAt(j));
                    }
                }
                if (!haveDuplicateCharacters && windowChecked) {
                    return k;
                }
            }
        }
        return 1;
    }


    /*
        Time: O(N)
        Memory: O(Mِ) M: Number of characters in the character set.
    */

    public static int lengthOfLongestSubstringUsingHashMap(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringUsingHashMap("dvdf")); // 3
        System.out.println(lengthOfLongestSubstringUsingHashMap("aab")); // 2
        System.out.println(lengthOfLongestSubstringUsingHashMap("abba")); // 2
        System.out.println(lengthOfLongestSubstringUsingHashMap("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstringUsingHashMap("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstringUsingHashMap("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstringUsingHashMap("")); // 0
        System.out.println(lengthOfLongestSubstringUsingHashMap("abababababa")); // 2
        System.out.println(lengthOfLongestSubstringUsingHashMap("a")); // 1
        System.out.println(lengthOfLongestSubstringUsingHashMap("ab")); // 2
    }
}
