package Stack;


import java.util.ArrayDeque;
import java.util.Stack;

/**
 * insert element in stack in sorted order
 */
public class Q3_Sorted_Insert_in_stack {

    /**
     * Q1. sorted insert
     * Time Complexity - o(n)
     * Space Complexity - o(n) system stack space
     */
    private void sortedInsert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() > value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            sortedInsert(stack, value);
            stack.push(temp);
        }
    }


    /**
     * Q2. sort stack
     * input is stack, we need to sort that stack.
     */
    private Stack<Integer> sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return stack;

        Stack<Integer> answer = new Stack<>();
        for (int number : stack) {
            sortedInsert(answer, number);
        }
        return stack;
    }


    /**
     * Q3. Bottom insert.
     * insert the element at the bottom of stack.
     */
    public void bottomInsert(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            bottomInsert(stack, value);
            stack.push(temp);
        }
    }

    /**
     * Q4. Reverse stack
     *  - Reverse k element from stack.
     */
    public void reverseStack(Stack<Integer> stack) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.removeFirst());
        }
    }


    public static void main(String[] args) {

    }
}
