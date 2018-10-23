package rcAlgorithm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class 把数组排成最小的数 {

    public String getMinu (int[] arr) {
        List<Integer> list = IntStream.of(arr).boxed()
                .sorted((s1, s2) -> {
                    String s12 = s1 + "" + s2;
                    String s21 = s2 + "" + s1;
                    return s12.compareTo(s21);
                })
                .collect(Collectors.toList());

        String rs = "";
        for (int i = 0; i < list.size(); i++) {
            rs = rs + list.get(i);
        }

        return rs;
    }

    public static void main (String[] args) {
        int[] arr = {3, 32, 321, 4, 5, 6, 11};
        把数组排成最小的数 test = new 把数组排成最小的数();
        System.out.println(test.getMinu(arr));
    }
}
