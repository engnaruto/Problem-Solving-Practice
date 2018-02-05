
/*
    You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
    Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

    The letters in J are guaranteed distinct, and all characters in J and S are letters.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".

    Example 1:
    Input: J = "aA", S = "aAAbbbb"
    Output: 3

    Example 2:
    Input: J = "z", S = "ZZ"
    Output: 0

    Note:
    - S and J will consist of letters and have length at most 50.
    - The characters in J are distinct.
*/

public class _771_JewelsAndStones {

    /*
        Time: O(N + M) Length of S + Length of J
        Memory: O(1) Constant value for every test
    */

    public static int numJewelsInStones(String J, String S) {
        boolean[] typesOfJewels = new boolean[128];

        for (char c : J.toCharArray()) {
            typesOfJewels[c] = true;
        }

        int counter = 0;

        for (char c : S.toCharArray()) {
            if (typesOfJewels[c]) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        String[][] tests = {
                {"aA", "aAAbbbb"},
                {"z", "ZZ"}
        };

        for (String[] test : tests) {
            System.out.println(numJewelsInStones(test[0], test[1]));
        }
    }
}
