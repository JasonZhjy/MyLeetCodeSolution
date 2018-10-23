package rcAlgorithm;

/**
 * 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
 */
public class 连续数组和 {

    public void getSum (int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int subSum = 0;
            for (int j = i; j < arr.length; j++) {
                subSum += arr[j];
                if (subSum == target) {
                    print(arr, i, j);
                    break;
                }
            }
        }
    }

    private void print (int[] arr, int left, int right) {
        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        连续数组和 test = new 连续数组和();
        test.getSum(arr, target);
    }

}
