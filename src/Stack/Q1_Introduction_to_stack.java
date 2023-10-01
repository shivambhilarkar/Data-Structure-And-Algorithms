package Stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class Q1_Introduction_to_stack {

    public static void main(String[] args) {


        /**
         * stack
         * first in last out data structure
         * push and pop - o(1) operation
         * stack can be implement in two ways in java
         * - Stack<Integer> stack = new Stack<>();
         * - push, pop, isEmpty,
         * ------------------------------------------------
         * - ArrayDeque<Integer> stack = new ArrayDeque<>();
         * - push == addFirst,
         * - pop == removeFirst,
         * - removeFirst, removeLast
         */

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println("[ Stack : " + stack1 + " ]");

        ArrayDeque<Integer> stack2 = new ArrayDeque<Integer>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println("[ Deque Stack : " + stack2 + " ]");


    }
}
