package leetcode.problems;


import java.util.*;

/*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine
    if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
    Example 1:

    Input: s = "leetcode", wordDict = ["leet", "code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".
    Example 2:

    Input: s = "applepenapple", wordDict = ["apple", "pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
                 Note that you are allowed to reuse a dictionary word.
    Example 3:

    Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    Output: false
*/

public class _139_WordBreak {

    /*
        Time: O(N * (M ^ 2)) M: Max length of a String in the dictionary.
                             Don't forget that string.Substring() takes O(M).
        Memory: O(wordDict.size())
    */

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length()];

        int maxLength = 1;

        for (String ss: set) {
            maxLength = Math.max(maxLength, ss.length());
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLength; j > i; j--) {
                if ((i == 0 || dp[i - 1]) && j <= s.length() && set.contains(s.substring(i, j))) {
                    if (j == s.length()) {
                        return true;
                    } else {
                        dp[j - 1] = true;
                    }
                }
            }
        }
        return false;
    }


    /*
        Time: O(N ^ 3) Don't forget that string.Substring() takes O(N)
        Memory: O(wordDict.size())
    */

    public static boolean wordBreakBFS(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        HashSet<String> set = new HashSet<>(wordDict);


        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while (!q.isEmpty()) {
            int start = q.poll();

            for (int i = s.length(); i > start; i--) {
                if (visited.contains(i - 1)) {
                    continue;
                }
                if ((start == 0 || visited.contains(start - 1)) && set.contains(s.substring(start, i))) {
                    if (i == s.length()) {
                        return true;
                    } else {
                        visited.add(i - 1);
                        q.add(i);
                    }
                }
            }

        }
        return false;
    }


    /*
        Time Limit
    */

    public static boolean wordBreak3(String s, List<String> wordDict) {
        HashMap<Character, ArrayList<String>> dic = new HashMap<>();
        char c;
        for (String word : wordDict) {
            c = word.charAt(0);
            ArrayList<String> list = dic.getOrDefault(c, new ArrayList<>());
            list.add(word);
            dic.put(c, list);
        }

        for (HashMap.Entry<Character, ArrayList<String>> entry : dic.entrySet()) {
            entry.getValue().sort((o1, o2) -> o2.length() - o1.length());
        }
        return solve(dic, s, 0);
    }

    private static boolean solve(HashMap<Character, ArrayList<String>> dic, String s, int index) {
        if (index >= s.length()) {
            return true;
        }

        boolean isSolved = false;
        char c = s.charAt(index);

        ArrayList<String> list = dic.getOrDefault(c, new ArrayList<>());

        if (list.isEmpty()) {
            return false;
        } else {
            for (String word : list) {
                if (s.regionMatches(index, word, 0, word.length())) {
                    isSolved = solve(dic, s, index + word.length());
                    if (isSolved) {
                        break;
                    }
                }
            }
        }
        return isSolved;
    }

    public static void main(String[] args) {

        String s = "aaab";
        String[] strs = {"aa","ab"};
        ArrayList<String> wordDict = new ArrayList<>(Arrays.asList(strs));

        System.out.println(wordBreak(s, wordDict));

        s = "leetcode";
        strs = new String[]{"leet", "code"};
        wordDict = new ArrayList<>(Arrays.asList(strs));

        System.out.println(wordBreak(s, wordDict));


        s = "applepenapple";
        strs = new String[]{"apple", "pen"};
        wordDict = new ArrayList<>(Arrays.asList(strs));

        System.out.println(wordBreak(s, wordDict));


        s = "catsandog";
        strs = new String[]{"cats", "dog", "sand", "and", "cat"};
        wordDict = new ArrayList<>(Arrays.asList(strs));

        System.out.println(wordBreak(s, wordDict));


        s = "aaaaaaaaaaaaaaaaaaaa";
        strs = new String[]{"a", "aa", "aaa", "aaaaaa", "aaaaaaaaa"};
        wordDict = new ArrayList<>(Arrays.asList(strs));

        System.out.println(wordBreak(s, wordDict));

    }

}
