package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int idx = 0, val = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > val) {
                if (idx == i - 1) {
                    val = nums[i];
                    idx = i;
                } else {
                    nums[++idx] = nums[i];
                    nums[i] = val;
                    val = nums[idx];
                }
            }
        }

        return idx + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
        int[] nums = {};
        System.out.println(test.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
