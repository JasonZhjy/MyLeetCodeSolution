package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 33. 搜索旋转排序数组
 */
public class 搜索旋转排序数组 {

    public int search (int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid, rs = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            //右边是有序的
            if (nums[mid] == target) {
                rs = mid;
                break;
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return rs;
    }

    public static void main (String[] args) {
//        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr = {3, 5, 1};
        int target = 3;
        搜索旋转排序数组 test = new 搜索旋转排序数组();
        System.out.println(test.search(arr, target));

        List<Integer> list = new ArrayList<>();
    }
}
