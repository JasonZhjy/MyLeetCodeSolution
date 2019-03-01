package mytest;

public class MyCodeTest {
    public double findMedianSortedArrays (int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if ((len1 + len2) % 2 == 0) {
            return (findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (len1 + len2) / 2)
                    + findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (len1 + len2) / 2 + 1)
            ) / 2;
        } else {
            return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (len1 + len2) / 2 + 1);
        }
    }

    public double findKth (int[] nums1, int beg1, int end1, int[] nums2, int beg2, int end2, int k) {
        int len1 = end1 - beg1 + 1, len2 = end2 - beg2 + 1;
        if (len1 > len2) {
            return findKth(nums2, beg2, end2, nums1, beg1, end1, k);
        }
        if (len1 == 0) {
            return nums2[beg2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[beg1], nums2[beg2]);
        }

        int p = Math.min(k / 2, len1);
        int q = k - p;
        if (nums1[beg1 + p - 1] == nums2[beg2 + q - 1]) {
            return nums1[beg1 + p - 1];
        } else if (nums1[beg1 + p - 1] > nums2[beg2 + q - 1]) {
            return findKth(nums1, beg1, end1, nums2, beg2 + q, end2, k - q);
        } else {
            return findKth(nums1, beg1 + p, end1, nums2, beg2, end2, k - p);
        }
    }

    public static void main (String[] args) {
        int[] nums1 = {1, 5, 6}, nums2 = {2, 3, 4, 7, 8};
        MyCodeTest test = new MyCodeTest();
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
