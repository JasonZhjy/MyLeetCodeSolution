package algorithm;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if ((len1 + len2) % 2 == 0) {
            return (findKth(nums1, nums2, 0, len1, 0, len2, (len1 + len2) / 2)
                    + findKth(nums1, nums2, 0, len1, 0, len2, (len1 + len2) / 2 + 1)
            ) / 2;
        } else {
            return findKth(nums1, nums2, 0, len1, 0, len2, (len1 + len2) / 2 + 1);
        }
    }

    double findKth(int[] nums1, int[] nums2, int beg1, int len1, int beg2, int len2, int k) {
        if (len1 > len2) {
            return findKth(nums2, nums1, beg2, len2, beg1, len1, k);
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
            return findKth(nums1, nums2, beg1, len1, beg2 + q, len2 - q, k - q);
        } else {
            return findKth(nums1, nums2, beg1 + p, len1 - p, beg2, len2, k - p);
        }
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays test = new MedianofTwoSortedArrays();
        int[] nums2 = {1}, nums1 = {2, 3, 4, 5};
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
