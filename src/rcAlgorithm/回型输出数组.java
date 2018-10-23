package rcAlgorithm;

public class 回型输出数组 {

    public void huiPrint (int[][] arr) {
        int top = 0, tail = arr.length - 1, left = 0, right = 0;
        if (arr.length == 0) {
            return;
        } else {
            right = arr[0].length - 1;
            print(arr, top, tail, left, right);
        }
    }

    public void print (int[][] arr, int top, int tail, int left, int right) {
        for (int i = left; i <= right; i++) {
            System.out.print(arr[top][i] + " ");
        }
        for (int j = top + 1; j <= tail; j++) {
            System.out.print(arr[j][right] + " ");
        }
        for (int i = right - 1; i >= left; i--) {
            System.out.print(arr[tail][i] + " ");
        }
        for (int j = tail - 1; j > top; j--) {
            System.out.print(arr[j][left] + " ");
        }

        if (left + 1 < right && top + 1 < tail) {
            print(arr, top + 1, tail - 1, left + 1, right - 1);
        }

    }

    public static void main (String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        回型输出数组 test = new 回型输出数组();
        test.huiPrint(arr);
    }
}
