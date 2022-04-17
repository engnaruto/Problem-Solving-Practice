package other.implementations;

public class RabinKarpAlgorithm {


    private static boolean check(String pattern, String text, int start) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != text.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }


    public static long calculateHash(int prime, String s, int start, int end) {
        int hash = 0;
        for (int i = start; i < end; i++) {
            hash += s.charAt(i) * Math.pow(prime, i);
        }
        return hash;
    }


    public static long recalculateHash(int prime, long hash, String text, int oldIndex, int newIndex, int patternLength) {
        hash -= text.charAt(oldIndex);
        hash /= prime;
        hash += text.charAt(newIndex) * Math.pow(prime, patternLength - 1);
        return hash;
    }


    public static int rabinKarb(String pattern, String text) {

        int prime = 101;
        long hashPattern = calculateHash(prime, pattern, 0, pattern.length());

        long hashText = calculateHash(prime, text, 0, pattern.length());

        for (int i = 1; i <= text.length() - pattern.length() + 1; i++) {


            if (hashPattern == hashText && check(pattern, text, i - 1)) {
                return i - 1;
            }

            if (i < text.length() - pattern.length() + 1) {
                hashText = recalculateHash(prime, hashText, text, i - 1, i + pattern.length() - 1, pattern.length());
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        String pattern = "abc";
        String text = "abecdabc";

        System.out.println(rabinKarb(pattern, text));
    }
}
