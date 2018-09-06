package cracking.the.coding.interview.problems;


/*
    3.1
    Three in One: Describe how you could use a single array to implement three stacks.
*/

public class _3_1_ThreeInOne {


    public static class Stack {
        int[] arr;
        int[] index;
        int n;

        public Stack(int n) {
            arr = new int[n * 3];
            index = new int[3];
            this.n = n;
        }

        private int getLastIndexOfStack(int i) {
            return i * n + index[i];
        }

        /*
           Time: O(1)
        */
        public boolean push(int i, int value) {
            if (index[i] >= n) {

                try {
                    throw new Exception("Stack is Full");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return false;
            }

            arr[getLastIndexOfStack(i)] = value;
            index[i]++;
            return true;
        }

        /*
          Time: O(1)
        */
        public int pop(int i) {
            if (index[i] == 0) {
                try {
                    throw new Exception("Stack #" + i + " is Empty");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int val = arr[getLastIndexOfStack(i)];
            index[i]--;
            return val;
        }

        public void print() {
            System.out.println("********************");

            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < index[j]; i++) {
                    System.out.print(arr[(j * n + i)] + " ");
                }
                System.out.println();
            }
            System.out.println("********************");
            System.out.println();

        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack(3);

        stack.push(0, 5);
        stack.push(2, 6);
        stack.push(1, 7);
        stack.push(0, 8);
        stack.push(0, 9);
//        stack.push(0, 10);
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(1));
//        System.out.println(stack.pop(1));
        stack.print();
        stack.push(1, 99);
        stack.print();
    }
}
