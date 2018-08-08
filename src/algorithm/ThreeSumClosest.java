package algorithm;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 */
public class ThreeSumClosest {
    // 与15题相比， 不需要考虑重复数据的问题
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        Integer rs = null;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int curVal = nums[left] + nums[right] + nums[i];
                if (curVal < target) {
                    left++;
                } else if (curVal > target) {
                    right--;
                } else {
                    return target;
                }

                rs = rs == null ? curVal : Math.abs(target - curVal) < Math.abs(target - rs) ? curVal : rs;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        ThreeSumClosest test = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(test.threeSumClosest(nums, 1));

    }
}
