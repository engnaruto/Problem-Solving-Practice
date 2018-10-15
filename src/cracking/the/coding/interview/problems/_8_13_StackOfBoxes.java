package cracking.the.coding.interview.problems;


import java.util.Arrays;


/*
    8.13
    Stack of Boxes: You have a stack of n boxes, with widths w1 ' heights h1 ' and depths d1. The boxes
    cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly
    larger than the box above it in width, height, and depth. Implement a method to compute the
    height of the tallest possible stack. The height of a stack is the sum of the heights of each box.
*/

public class _8_13_StackOfBoxes {

    public static class Box {
        int width, depth, height;

        Box(int w, int d, int h) {
            width = w;
            depth = d;
            height = h;
        }

        public boolean isTopOf(Box box) {
            return box.height > height && box.depth > depth && box.width > width;
        }

        @Override
        public String toString() {
            return "(" + height + " - " + width + " - " + depth + ")";
        }
    }

    public static Box[] boxes;
    public static int[] dp = new int[1000];


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int stackOfBoxes(int index, Box lastBox) {

        if (index >= boxes.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int choose = 0;
        if (boxes[index].isTopOf(lastBox)) {
            choose = stackOfBoxes(index + 1, boxes[index]) + boxes[index].height;
        }
        choose = Math.max(choose, stackOfBoxes(index + 1, lastBox));

        return dp[index] = choose;
    }


    public static void main(String[] args) {

        boxes = new Box[]{
                new Box(5, 5, 5),
                new Box(1, 1, 1),
                new Box(6, 6, 6),
                new Box(3, 3, 3),
                new Box(4, 4, 4)

        };

        Arrays.fill(dp, -1);

        Arrays.sort(boxes,
                (o1, o2) -> o2.height - o1.height != 0 ?
                        o2.height - o1.height :
                        o2.width - o1.width);

        System.out.println(stackOfBoxes(0, new Box(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)));
    }
}
