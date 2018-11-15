package algorithm;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation (int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int pos = nums.length - 1;
        while (pos > 0 && nums[pos] <= nums[pos - 1]) {
            pos--;
        }

        if (pos == 0) {
            // 3 2 1
            Arrays.sort(nums);
            return;
        } else {
            if (pos == nums.length - 1) {
                swap(nums, pos, pos - 1);
                return;
            } else {
                // 2 [3] 2 1
                //找到pos位置之后的大于该节点值的最小值,注意pos位置之后的序列是逆序的
                int key = nums[pos - 1];
                int beg = nums.length - 1;
                while (beg > pos && nums[beg] <= key) {
                    beg--;
                }
                swap(nums, pos - 1, beg);
                Arrays.sort(nums, pos, nums.length);
            }
        }

    }

    public void swap (int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    public static void main (String[] args) {
        NextPermutation nextPermutation = new NextPermutation();

        int[] nums = {1, 3, 2};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
