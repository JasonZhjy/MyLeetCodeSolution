package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int threeSum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int twoSum = threeSum - nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum;
                    if ((sum = nums[left] + nums[right]) > twoSum) {
                        right--;
                    } else if (sum < twoSum) {
                        left++;
                    } else {
                        List<Integer> node = new ArrayList<>();
                        node.add(nums[i]);
                        node.add(nums[j]);
                        node.add(nums[left]);
                        node.add(nums[right]);
                        rs.add(node);
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                    }
                }
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }

        return rs;
    }

    public static void main(String[] args) {
        FourSum test = new FourSum();
//        int[] arr = {1, 0, -1, 0, -2, 2};
        int[] arr = {-1, 2, 2, -5, 0, -1, 4};
        int target = 3;
        List<List<Integer>> rs = test.fourSum(arr, target);

        for (List<Integer> list : rs) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
