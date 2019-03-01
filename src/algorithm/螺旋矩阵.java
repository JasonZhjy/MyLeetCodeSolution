package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder (int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        if (matrix.length == 0) {
            return rs;
        }

        print(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1, rs);
        return rs;
    }

    public void print (int[][] matrix, int l, int r, int t, int e, List<Integer> rs) {
        if (l > r || t > e) {
            return;
        }

        if (l <= r && t <= e) {
            for (int i = l; i <= r; i++) {
                rs.add(matrix[t][i]);
            }
            for (int i = t + 1; i < e; i++) {
                rs.add(matrix[i][r]);
            }
            for (int i = r; i > l && e != t; i--) {
                rs.add(matrix[e][i]);
            }
            for (int i = e; i > t && r != l; i--) {
                rs.add(matrix[i][t]);
            }

            if (r - l >= 2 && e - t >= 2) {
                print(matrix, l + 1, r - 1, t + 1, e - 1, rs);
            }
        }
    }

    public static void main (String[] args) {
        螺旋矩阵 t = new 螺旋矩阵();
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = t.spiralOrder(nums);
        list.forEach(i ->{
            System.out.print(i + " ");
        });
    }
}
