package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 27. Remove Element
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = IntStream.of(nums).boxed()
                .sorted((o1, o2) -> o1.intValue() == o2.intValue() ? 0 : (o2 == val ? -1 : 1))
                .collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return (int) list.stream().filter(v -> v.intValue() != val).count();
    }

    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int[] nums = {1, 2, 2, 3};
        System.out.println(test.removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
