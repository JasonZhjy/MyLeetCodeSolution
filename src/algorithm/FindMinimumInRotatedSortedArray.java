package algorithm;

/**
 * 153.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left < right && nums[left] > nums[right]) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public static void main (String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] nums = {1, 2};
        FindMinimumInRotatedSortedArray test = new FindMinimumInRotatedSortedArray();
        System.out.println(test.findMin(nums));
    }
}
