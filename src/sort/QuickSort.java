package sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;

public class QuickSort {

    public void quickSort (int[] A, int left, int right) {
        if (left < right) {
            int partition = partition(A, left, right);
            quickSort(A, left, partition);
            quickSort(A, partition + 1, right);
        }
    }

    public int partition (int[] A, int left, int right) {
        int temp = A[left], i = left, j = right;
        while (i < j) {
            while (i < j && A[j] >= temp) j--;
            if (i < j) A[i++] = A[j];
            while (i < j && A[i] < temp) i++;
            if (i < j) A[j--] = A[i];
        }
        A[i] = temp;

        return i;
    }

    public static void main (String[] args) {
        int[] A = {46, 79, 56, 38, 40, 84};
        QuickSort quickSort = new QuickSort();
        quickSort.partition(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

}
