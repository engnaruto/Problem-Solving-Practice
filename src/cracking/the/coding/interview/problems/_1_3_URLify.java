package cracking.the.coding.interview.problems;


/*
    1.3
    URLify: Write a method to replace all spaces in a string with '%20': You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)
    EXAMPLE
    Input: "Mr John Smith    ", 13
    Output: "Mr%20John%20Smith"
*/

public class _1_3_URLify {

    /*
        Note: You should check for the number of spaces to know where you should start in coping in the array.
        Time: O(N) Size of the array.
        Space: O(N) Size of the array used to have the characters of the string.
    */

    public static String urlify(String s, int length) {
        char[] arr = s.toCharArray();
        int stringIndex = length - 1;
        int spaceCount = 0;

        // correction:  int arrIndex = arr.length - 1; => should be like below
        for (int i = 0; i < length; i++) {
            if (arr[i] == ' ') {
                spaceCount++;
            }
        }

        int arrIndex = length + (spaceCount * 2) - 1;

        while (stringIndex >= 0) {
            if (arr[stringIndex] == ' ') {
                arr[arrIndex--] = '0';
                arr[arrIndex--] = '2';
                arr[arrIndex--] = '%';
            } else {
                arr[arrIndex--] = arr[stringIndex];
            }
            stringIndex--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {

        String[] tests = {"Mr John Smith      ", " Hiii hello  x           "};
        int[] tests2 = {13, 14};

        for (int i = 0; i < tests.length; i++) {
            System.out.println(urlify(tests[i], tests2[i]));
        }
    }
}
