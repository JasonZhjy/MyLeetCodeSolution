package rcAlgorithm;

import java.util.Arrays;

/**
 * 《剑指offer》-扑克牌顺子
 * 从扑克牌中随机抽取5张，判断是不是一个顺子。2-10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以为任何数字。
 */
public class 扑克牌是否为顺子 {
    public boolean isShunZi (int[] num) {
        int[] paid = new int[13];
        Arrays.fill(paid, 0);
        for (int i = 0; i < num.length; i++) {
            paid[num[i]]++;
        }
        Arrays.sort(num);
        int beg = 0, end = num.length - 1, zeroCount = 0;
        while (num[beg] == 0) {
            zeroCount++;
            beg++;
        }

        for (int j = num[beg]; j <= num[end]; j++) {
            if (paid[j] > 1) {
                return false;
            } else if (paid[j] == 1) {
                continue;
            } else if (zeroCount < 1) {
                return false;
            } else {
                zeroCount--;
            }
        }

        return true;
    }

    public static void main (String[] args) {
        int[] num = {0, 0, 1, 4, 5};
        扑克牌是否为顺子 test = new 扑克牌是否为顺子();
        System.out.println(test.isShunZi(num));
    }
}
