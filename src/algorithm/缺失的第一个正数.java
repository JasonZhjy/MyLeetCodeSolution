package algorithm;

import java.util.Arrays;

public class 缺失的第一个正数 {
    public int firstMissingPositive (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int k = nums[i];
                nums[i] = nums[k - 1];
                nums[k - 1] = k;
            }
        }

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                n = i + 1;
                break;
            }
        }
        if (n == 0) {
            n = nums.length + 1;
        }

        return n;
    }

    public static void main (String[] args) {
        缺失的第一个正数 test = new 缺失的第一个正数();
        int[] nums = {3, 4, -1, 1};
        System.out.println(test.firstMissingPositive(nums));
    }

}
