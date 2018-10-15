package cracking.the.coding.interview.problems;


/*
    1.6
    String Compression: Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

public class _1_6_StringCompression {

    /*
        Time: O(N + K ^ 2) where N: Length of the string, K: # of the sequences in the string.
        Memory: O(1)
    */

    public static String stringCompression(String str) {

        int count = 1;
        String compressed = "";
        for (int i = 1; i < str.length(); i++) {
            if (i == str.length() - 1) {
                if (str.charAt(i) != str.charAt(i - 1)) {
                    compressed += str.charAt(i - 1) + "" + count;
                    compressed += str.charAt(i) + "" + 1;
                } else {
                    compressed += str.charAt(i - 1) + "" + (count + 1);
                }
            } else {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    count++;
                } else {
                    compressed += str.charAt(i - 1) + "" + count;
                    count = 1;
                }
            }
        }

        if (str.length() > compressed.length()) {
            return compressed;
        }
        return str;
    }


    public static String stringCompressionWithStringBuilder(String str) {

        int count = 1;
        StringBuilder compressed = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (i == str.length() - 1) {
                if (str.charAt(i) != str.charAt(i - 1)) {
                    compressed.append(str.charAt(i - 1)).append(count);
                    compressed.append(str.charAt(i)).append(1);
                } else {
                    compressed.append(str.charAt(i - 1)).append(count + 1);
                }
            } else {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    count++;
                } else {
                    compressed.append(str.charAt(i - 1)).append(count);
                    count = 1;
                }
            }
        }

        if (str.length() > compressed.length()) {
            return compressed.toString();
        }
        return str;
    }


    public static void main(String[] args) {
        String[] tests = {
                "aabcccccaaa",
                "abcd",
                "aaaaaabcd"
        };

        for (String test : tests) {
            System.out.println(stringCompression(test));
            System.out.println(stringCompressionWithStringBuilder(test));
        }
    }
}