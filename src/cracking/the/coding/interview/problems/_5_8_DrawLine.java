package cracking.the.coding.interview.problems;


/*
    5.8
    Draw Line: A monochrome screen is stored as a single array of bytes, allowing eight consecutive
    pixels to be stored in one byte. The screen has width w, where w is divisible by 8
    (that is, no byte will be split across rows). The height of the screen, of course,
    can be derived from the length of the array and the width.
    Implement a function that draws a horizontal line from (x1, y) to (x2, y).
    The method signature should look something like:
    drawLine(byte[] screen, int width, int x1, int x2, int y)

    |--------------- width -----------|_
    00000000 00000000 00000000 00000000 | x1 = x1 / 8 to know x1 in which byte
    00000000 00000111 11111111 11000000 | x1 = x1 % 8 to know x1 in which bit
    00000000 00000000 00000000 00000000 y x1 = width * y + x1 / 8
    00000000 00000000 01111000 00000000 | x2 = width * y + x2 / 8
    00000000 00000000 00000000 00000000_|
*/


public class _5_8_DrawLine {

    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int b1 = width * y + x1;
        int byte1 = b1 / 8;
        int bit1 = b1 % 8;
        int b2 = width * y + x2;
        int byte2 = b2 / 8;
        int bit2 = b2 % 8;

        System.out.println(b1 + ", " + byte1 + ", " + bit1);
        System.out.println(b2 + ", " + byte2 + ", " + bit2);


        if (byte1 != byte2) {
            for (int i = byte1; i <= byte2; i++) {
                if (i == byte1) {
                    screen[i] = (byte) ((1 << (8 - bit1)) - 1);
                } else if (i == byte2) {
                    screen[i] = (byte) (~((1 << (8 - bit2 - 1)) - 1));
                } else {
                    screen[i] = ~0;
                }
            }
        } else {
            screen[byte1] = (byte) ((1 << (8 - bit1)) - 1);
            screen[byte1] &= (byte) (~(1 << (8 - bit2 - 1) - 1));
        }


        for (int i = 0; i < screen.length; i++) {
            if (i % (width / 8) == 0) {
                System.out.println();
            }
            System.out.print(screen[i]
                    + ", ");

        }
        for (int i = 0; i < screen.length; i++) {
            if (i % (width / 8) == 0) {
                System.out.println();
            }
            System.out.print((Integer.toBinaryString(screen[i]).length() > 8 ?
                    Integer.toBinaryString(screen[i]).substring(24) : Integer.toBinaryString(screen[i])) + ", ");

        }
    }

    public static void main(String[] args) {
        byte[] screen = {
                0, 0, 0,
                0, 0, 0,
                0, 0, 0
        };

        drawLine(screen, 24, 5, 20, 1);
        drawLine(screen, 24, 2, 6, 2);
    }
}
