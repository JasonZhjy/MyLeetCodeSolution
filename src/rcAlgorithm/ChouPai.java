package rcAlgorithm;

import java.util.LinkedList;

/**
 * 老闫的抽牌问题: 一堆牌，顶张取出，次张放牌低，最终取出的为增序列，求原数组.
 */
public class ChouPai {
    public static void main (String[] args) {
        int[] p = {1, 2, 3, 4, 5, 6, 7};
        asd(p);
    }

    private static void asd (int[] p) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < p.length; i++) {
            list.add(0, p[i]);
            if (i != p.length - 1) {
                list.add(0, list.removeLast());
            }
        }

        list.forEach(System.out::println);
    }
}
