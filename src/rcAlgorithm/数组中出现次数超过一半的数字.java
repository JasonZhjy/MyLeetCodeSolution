package rcAlgorithm;

public class 数组中出现次数超过一半的数字 {

    public int moreThanHalfNum (int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int account = 1, subMax = num[0];
        for (int i = 1; i < num.length; i++) {
            if (subMax == num[i]) {
                account++;
            } else if (account == 0) {
                subMax = num[i];
                account++;
            } else {
                account--;
            }
        }

        return subMax;
    }

    public static void main (String[] args) {
        数组中出现次数超过一半的数字 test = new 数组中出现次数超过一半的数字();
        int[] num = {1, 2, 2, 2, 2, 2, 2, 4, 2, 4, 6, 4, 2, 6, 8, 2, 7, 7};
        System.out.println(test.moreThanHalfNum(num));

    }
}
