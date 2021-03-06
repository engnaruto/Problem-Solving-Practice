package leetcode.problems;


import java.util.*;


/*
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
    sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

    Note:

        Return 0 if there is no such transformation sequence.
        All words have the same length.
        All words contain only lowercase alphabetic characters.
        You may assume no duplicates in the word list.
        You may assume beginWord and endWord are non-empty and are not the same.

    Example 1:

    Input:

    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output: 5

    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Example 2:

    Input:

    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    Output: 0

    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 */

public class _127_WordLadder {

    public static class Pair {
        int wordIndex;
        int level;
        public Pair(int wordIndex, int level) {
            this.wordIndex = wordIndex;
            this.level = level;
        }
    }

    /*
        Time: O(N ^ 2)
        Memory: O(N ^ 2)
    */

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i< wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                index1 = i;
            } else if (wordList.get(i).equals(endWord)) {
                index2 = i;
            }
        }

        if (index2 == -1) {
            return 0;
        }

        if (index1 == -1) {
            wordList.add(beginWord);
            index1 = wordList.size() - 1;
        }

        ArrayList<Integer>[] graph = new ArrayList[wordList.size()];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        String s1, s2;
        int count = 0;

        for (int i = 0; i < wordList.size(); i++) {
            s1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                s2 = wordList.get(j);
                count = 0;
                for (int k = 0; k < s1.length(); k++) {
                    if (s1.charAt(k) != s2.charAt(k)) {
                        count++;
                    }
                    if (count > 1) {
                        break;
                    }
                }
                if (count == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        queue.add(new Pair(index1, 1));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            visited[p.wordIndex] = true;

            for (int i : graph[p.wordIndex]) {
                if (i == index2) {
                    return p.level + 1;
                } else if (!visited[i]) {
                    queue.add(new Pair(i, p.level + 1));
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, "hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));


        beginWord = "hit";
        endWord = "cog";
        wordList = new ArrayList<>();
        Collections.addAll(wordList, "hot", "dot", "dog", "lot", "log");

        System.out.println(ladderLength(beginWord, endWord, wordList));

        beginWord = "hit";
        endWord = "hat";
        wordList = new ArrayList<>();
        Collections.addAll(wordList, "hat");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
