package cracking.the.coding.interview.problems;


import java.util.Stack;

/*
    8.6
    Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
    different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
    of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following
    constraints:
    (1) Only one disk can be moved at a time.
    (2) A disk is slid off the top of one tower onto another tower.
    (3) A disk cannot be placed on top of a smaller disk.
    Write a program to move the disks from the first tower to the last using Stacks.
*/

public class _8_6_TowersOfHanoi {

    /*
        Time: O(2 ^ N)
        Memory: O(N)
    */

    public static void towersOfHanoi(int n, Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> destination) {
        if (n <= 0) {
            return;
        }

        System.out.println("Source: " + (source.isEmpty() ? "EMPTY" : source.toString()));
        System.out.println("Buffer: " + (buffer.isEmpty() ? "EMPTY" : buffer.toString()));
        System.out.println("Destination: " + (destination.isEmpty() ? "EMPTY" : destination.toString()));
        System.out.println("-----------------------------------");


        towersOfHanoi(n - 1, source, destination, buffer);
        destination.add(source.pop());

        towersOfHanoi(n - 1, buffer, source, destination);
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        System.out.println(s);
        towersOfHanoi(s.size(), s, new Stack<>(), s2);
        System.out.println("******************");
        System.out.println(s2);
    }
}
