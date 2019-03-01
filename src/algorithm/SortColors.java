package algorithm;

public class SortColors {
    public void sortColors(int[] nums) {
        int l = -1, r = nums.length;
        int i = 0;
        while (i < r) {
            if (nums[i] < 1) {
               swap(nums, ++l, i++);
            } else if (nums[i] > 1) {
                swap(nums, --r, i);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int k = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = k;
    }
}
