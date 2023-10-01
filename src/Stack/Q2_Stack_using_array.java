package Stack;

import java.util.Arrays;

/**
 * create stack using array.
 * push, pop, isEmpty, size functions
 */
class MyStack {

    private final int[] array;
    private int index;

    MyStack(int size) {
        this.array = new int[size];
        this.index = -1;
    }

    /**
     * add Element to stack
     */
    public void push(int value) throws Exception {
        if (index >= array.length - 1) {
            throw new Exception("[ Stack overflow ]");
        }
        index += 1;
        array[index] = value;
    }

    /**
     * remove element from stack
     */
    public int pop() throws Exception {
        if (index == -1) {
            throw new Exception("[ Stack underflow. ]");
        }
        int value = array[index];
        array[index--] = 0;
        return value;
    }

    /**
     * return stack size
     */
    public int size() {
        return index + 1;
    }

    /**
     * isEmpty
     */
    public boolean isEmpty() {
        return index < 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}


public class Q2_Stack_using_array {


    public static void main(String[] args) throws Exception {

        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);

        stack.pop();


    }


}
