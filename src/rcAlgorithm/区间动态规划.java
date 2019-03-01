package rcAlgorithm;

/**
 * 两个长度为n的序列a, b，问有多少个区间[l,r]满足如下式子：
 * max(a[l,r])<min(b[l,r]),0≤l≤r<nmax(a[l,r])<min(b[l,r]),0≤l≤r<n
 * 即a区间的最大值小于b区间的最小值。
 * 数值范围： n<1e5, aibi<1e9
 * <p>
 * 输入描述
 * 第一行一个整数n
 * 第二行n个数，第i个为ai
 * 第三行n个数，第i个为bi
 * 1
 * 2
 * 3
 * 输出描述
 * 一行一个整数，表示答案
 * 1
 * 示例
 * 输入
 * 3
 * 3 2 1
 * 3 3 3
 * 1
 * 2
 * 3
 * 输出
 * 3
 */
public class 区间动态规划 {

    public int getNum (int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        int rs = 0;
        int max, min;
        for (int i = 0; i < nums1.length; i++) {
            max = nums1[i];
            min = nums2[i];
            if (max >= min) continue;
            int len = 1;
            for (int j = i + 1; j < nums1.length; j++) {
                max = Math.max(max, nums1[j]);
                min = Math.min(min, nums2[j]);
                if (max >= min) break;
                len++;
            }
            rs += len;
        }

        return rs;
    }

    public static void main (String[] args) {
        int[] nums1 = {3, 2, 1}, nums2 = {3, 3, 3};
        区间动态规划 test = new 区间动态规划();
        System.out.println(test.getNum(nums1, nums2));
    }
}
