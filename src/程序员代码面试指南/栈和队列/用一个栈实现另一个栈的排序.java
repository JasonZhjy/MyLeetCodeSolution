package 程序员代码面试指南.栈和队列;

import java.util.LinkedList;
import java.util.Stack;

public class 用一个栈实现另一个栈的排序 {
    public static void sort (Stack<Integer> stack) {
        Stack<Integer> heap = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!heap.isEmpty() && heap.peek() < cur) {
                stack.push(heap.pop());
            }
            heap.push(cur);
        }

        while (!heap.isEmpty()) {
            stack.push(heap.pop());
        }
    }

    public static void main (String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
