package algorithm;

public class MaximumSubarray {
    //遍历方法 时间复杂度为O(N^2)
    public int maxSubArray(int[] nums) {
        int rs = 0, subMax = 0;
        for (int i = 0; i < nums.length; ++i) {
            subMax = 0;
            for (int j = i; j < nums.length; ++j) {
                subMax += nums[j];
                rs = rs < subMax ? subMax : rs;
            }
        }

        return rs;
    }

    /**
     * 使用递归
     * <p>
     * 对于一数字序列，其最大连续子序列和对应的子序列可能出现在三个地方。
     * 或是整个出现在输入数据的前半部（左），
     * 或是整个出现在输入数据的后半部（右），
     * 或是跨越输入数据的中部从而占据左右两半部分。
     * 前两种情况可以通过递归求解，
     * 第三种情况可以通过求出前半部分的最大和（包含前半部分的最后一个元素）以及后半部分的最大和（包含后半部分的第一个元素）
     * 而得到，然后将这两个和加在一起即可。
     *
     * @param nums
     * @return
     */
    public int maxSubArray_solution2(int[] nums) {
        return maxSubSum(nums, 0, nums.length - 1);
    }

    private int maxSubSum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSubSum(nums, left, center);
        int maxRightSum = maxSubSum(nums, center + 1, right);

        int leftBorderSum = 0, maxLeftBorderSum = Integer.MIN_VALUE;
        for (int i = center; i >= left; --i) {
            leftBorderSum += nums[i];
            maxLeftBorderSum = Math.max(leftBorderSum, maxLeftBorderSum);
        }

        int rightBorderSum = 0, maxRightBorderSum = Integer.MIN_VALUE;
        for (int i = center + 1; i <= right; ++i) {
            rightBorderSum += nums[i];
            maxRightBorderSum = Math.max(maxRightBorderSum, rightBorderSum);
        }

        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
    }

    /**
     * 动态规划
     * 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
     * @param nums
     * @return
     */
    public int maxSubArray_solution3(int[] nums) {
        int maxVal = Integer.MIN_VALUE, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (b > 0) {
                b += nums[i];
            } else {
                b = nums[i];
            }
            if (b > maxVal) maxVal = b;
        }

        return maxVal;
    }


    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        int[] arr = {-2, 1, -3, -4, -1, -2, 1, -5, -4};
        System.out.println(test.maxSubArray_solution3(arr));
    }

}
