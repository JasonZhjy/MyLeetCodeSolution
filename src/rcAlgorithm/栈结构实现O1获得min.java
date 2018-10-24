package rcAlgorithm;

import java.util.Comparator;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的getMin函数。
 * 在该栈中，调用getMin、push及pop的时间复杂度都是O(1)
 */
public class 栈结构实现O1获得min<T extends Comparable> {

    private Stack<T> stack = new Stack<>();
    private Stack<T> minStack = new Stack<>();
    private Stack<T> maxStack = new Stack<>();

    /**
     * get the top data.
     *
     * @return
     */
    public T pop () {
        minStack.pop();
        maxStack.pop();
        return stack.pop();
    }

    public void push (T item) {
        if (stack.isEmpty()) {
            minStack.push(item);
            maxStack.push(item);
            stack.push(item);
        } else {
            T oldMax = maxStack.peek();
            maxStack.push(oldMax.compareTo(item) > 0 ? oldMax : item);

            T oldMin = minStack.peek();
            minStack.push(oldMin.compareTo(item) < 0 ? oldMin : item);
            stack.push(item);
        }
    }

    public T getMin () {
        return minStack.peek();
    }

    public T getMax () {
        return maxStack.peek();
    }

    public static void main (String[] args) {
        栈结构实现O1获得min<Integer> test = new 栈结构实现O1获得min();
        test.push(3);
        test.push(1);
        test.push(2);

        System.out.println(test.getMax());
        System.out.println(test.getMin());


    }

}
