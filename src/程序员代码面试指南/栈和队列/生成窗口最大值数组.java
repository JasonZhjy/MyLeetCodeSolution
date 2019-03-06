package 程序员代码面试指南.栈和队列;

import java.util.LinkedList;

public class 生成窗口最大值数组 {

    /**
     * i: 0 -> arr.length - w
     *
     * @param arr
     * @param w
     * @return
     */
    public static int[] getMaxWindow (int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.push(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i - w + 1 > 0) {
                res[idx++] = arr[qmax.peekFirst()];
            }
        }

        return res;
    }
}
