

/*
    5.2
    Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
    the binary representation. If the number cannot be represented accurately in binary with at most 32
    characters, print "ERROR".
*/

public class _5_2_BinaryToString {

    /*
        Time: O(Log(N)) OR O(b(N)) number of bits in N
        Memory: O(1)
    */

    public static String binaryToString(double num) {

        StringBuilder builder = new StringBuilder();
        builder.append("0.");

        int reminder = 0;
        for (int i = 0; i < 32; i++) {
            num *= 2;
            reminder = (int) (num % 10);
            builder.append(reminder);
            num -= reminder;
            if (num == 0) {
                break;
            }
        }

        if (num > 0.0) {
            return "ERROR";
        } else {
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(binaryToString(.6));
    }

}
