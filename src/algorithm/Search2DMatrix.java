package algorithm;

public class Search2DMatrix {
    public boolean searchMatrix (int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0, right = matrix.length * matrix[0].length - 1;

        return findVal(matrix, target, left, right);

    }

    public boolean findVal (int[][] matrix, int target, int left, int right) {
        boolean flag = false;
        if (left <= right) {
            int mid = (left + right) / 2;
//            int i =
            int midVal = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (midVal == target) {
                flag = true;
            } else if (target > midVal) {
                flag = findVal(matrix, target, mid + 1, right);
            } else {
                flag = findVal(matrix, target, left, mid - 1);
            }
        }

        return flag;
    }

    public static void main (String[] args) {
        Search2DMatrix test = new Search2DMatrix();
//        int[][] nums = {{1, 3, 5, 7}, {8, 9, 11, 12}, {13, 21, 22, 44}};
        int[][] nums = {{1, 1}};
        System.out.println(test.searchMatrix(nums, 3));
    }
}
