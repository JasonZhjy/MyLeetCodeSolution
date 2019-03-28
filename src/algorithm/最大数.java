package algorithm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 179.
 */
public class 最大数 {

    public String largestNumber (int[] nums) {

        List<Integer> collect = IntStream.of(nums).boxed().sorted(
                (n1, n2) -> {
                    Long p1 = Long.valueOf(n1 + "" + n2);
                    Long p2 = Long.valueOf(n2 + "" + n1);
                    if (p1 < p2)
                        return 1;
                    return -1;
                }
        ).collect(Collectors.toList());
        if (collect.get(0) == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer k : collect) {
            sb.append(k);
        }

        return sb.toString();
    }


    public static void main (String[] args) {
        最大数 test = new 最大数();
        int[] nums = {999999998, 999999997, 999999999};
        test.largestNumber(nums);
    }
}
