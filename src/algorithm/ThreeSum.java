package algorithm;

import java.util.*;

/**
 * 15. 3Sum
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> hasContain = new HashSet<>();
        Set<Integer> hasContain2 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hasContain.contains(nums[i])) {
                continue;
            }
            hasContain.add(nums[i]);
            int last = 0 - nums[i];
            int left = i + 1, right = nums.length - 1;
            hasContain2.clear();
            while (left < right) {
                if (hasContain2.contains(nums[left]) || nums[left] + nums[right] < last) {
                    left++;
                } else if (nums[left] + nums[right] > last) {
                    right--;
                } else if (!hasContain2.contains(nums[left])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    hasContain2.add(nums[left++]);
                    rs.add(list);
                }
            }
        }

        return rs;
    }

    // 优化
    public List<List<Integer>> threeSum_solution2(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int last = 0 - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < last) {
                    left++;
                } else if (nums[left] + nums[right] > last) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    // 移除重复数据
                    while (left < right && nums[left] == nums[left + 1]) ++left;
                    while (left < right && nums[right] == nums[right - 1]) --right;
                    rs.add(list);
                }
            }
            // 移除重复数据
            while (i < nums.length && nums[i] == nums[i + 1]) ++i;
        }

        return rs;
    }


    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {0, -4, -1, -4, -2, -3, 2};
        List<List<Integer>> rs = test.threeSum(nums);
        for (List<Integer> list : rs) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
