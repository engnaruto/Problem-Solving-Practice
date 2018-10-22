import java.util.*;


/*
    Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.
    Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

    However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

    You need to return the least number of intervals the CPU will take to finish all the given tasks.

    Example 1:

    Input: tasks = ["A","A","A","B","B","B"], n = 2

    Output: 8

    Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

    Note:

    1- The number of tasks is in the range [1, 10000].
    2- The integer n is in the range [0, 100].
*/

public class _621_TaskScheduler {


    /*
        Time: O(t) t: the time taken from the cpu to process the tasks
        Memory: O(1) The memory will not exceed O(26)
    */

    public static int leastInterval(char[] tasks, int n) {

        int[] tasksCounter = new int[26];

        for (char c : tasks) {
            tasksCounter[(int) c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Stack<Integer> s = new Stack<>();

        int counter = 0;

        for (int i : tasksCounter) {
            if (i != 0) {
                pq.add(i);
            }
        }

        int num = 0;

        while (!pq.isEmpty()) {
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    num = pq.poll() - 1;

                    if (num != 0) {
                        s.push(num);
                    }
                }

                counter++;

                if ((s.isEmpty() && pq.isEmpty())) {
                    break;
                }
            }

            while (!s.isEmpty()) {
                pq.add(s.pop());
            }
        }

        return counter;
    }


    public static void main(String[] args) {

        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E'};
        System.out.println(leastInterval(tasks, 2));
        tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks, 2));
    }
}
