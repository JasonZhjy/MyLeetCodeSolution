package 剑指Offer;

import java.util.Arrays;

/**
 * 面试题3. 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0 - n-1的范围内，
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * eg. 数组{2, 3, 1, 0, 2, 5, 3}, 那么对应重复的数字是2或3
 */
@SuppressWarnings("unused")
public class Case3 {

    /**
     * 使用了一个一维数组
     * @param nums 输入数组
     * @return 结果
     */
    public Integer getAnyRepeated(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        int[] tmp = new int[nums.length];
        Arrays.fill(tmp, 0);

        for (int num : nums) {
            if (num > nums.length - 1 || num < 0) {
                break;
            }
            tmp[num] += 1;
            if (tmp[num] > 1) {
                return tmp[num];
            }
        }

        return null;
    }

    /**
     * 未使用其它空间
     * @param nums 输入数组
     * @return 结果
     */
    public Integer getAnyRepeated2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {

            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                swap(nums, i, nums[i]);
            }
        }

        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
}
