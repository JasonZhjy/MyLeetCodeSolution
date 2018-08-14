package algorithm.sort;

public class HeapSort {


    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    }


    private static void heapSort(int[] arr) {
        // build big top heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 2.
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            adjustHeap(arr, 0, j);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];      //get current node.

        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }

            if (arr[k] > temp) {    //交换并记录最后该节点的位置
                arr[i] = arr[k];
                i = k;
            }

            arr[i] = temp;
        }
    }

}
