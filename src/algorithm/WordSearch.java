package algorithm;
/*
79
 */

import java.util.Arrays;

public class WordSearch {

    int[] dh = {0, -1, 0, 1};
    int[] dw = {1, 0, -1, 0};

    public boolean exist (char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isThisWay(board, word, i, j, 0, isVisited))
                    return true;
            }
        }

        return false;
    }

    public boolean isThisWay (char[][] board, String word, int row, int col, int idx, boolean[][] isVisited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || isVisited[row][col] || board[row][col] != word.charAt(idx)) {
            return false;
        }
        if (++idx == word.length()) return true;
        for (int i = 0; i < 4; i++) {
            if (isThisWay(board, word, row + dw[i], col + dh[i], idx, isVisited)) {
                return true;
            }
        }
        isVisited[row][col] = false;
        return false;
    }


    /*
    典型DFS
     */
    public boolean exist2 (char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        clearIsVisited(isVisited);
        boolean isExist = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                isExist = DFS(board, 0, i, j, word, isVisited);
                if (isExist) break;
            }
            if (isExist) break;
        }
        return isExist;
    }

    public boolean DFS (char[][] board, int k, int row, int col, String word, boolean[][] isVisited) {
        if (k == word.length()) {
            return true;
        }
        boolean flag = false;
        char key = word.charAt(k);
        if (row - 1 >= 0 && board[row - 1][col] == key && !isVisited[row - 1][col]) {
            isVisited[row - 1][col] = true;
            flag = DFS(board, k + 1, row - 1, col, word, isVisited);
            isVisited[row - 1][col] = flag | false;
        }

        if (!flag && row + 1 < board.length && board[row + 1][col] == key && !isVisited[row + 1][col]) {
            isVisited[row + 1][col] = true;
            flag = DFS(board, k + 1, row + 1, col, word, isVisited);
            isVisited[row + 1][col] = flag | false;
        }

        if (!flag && col - 1 >= 0 && board[row][col - 1] == key && !isVisited[row][col - 1]) {
            isVisited[row][col - 1] = true;
            flag = DFS(board, k + 1, row, col - 1, word, isVisited);
            isVisited[row][col - 1] = flag | false;
        }

        if (!flag && col + 1 < board.length && board[row][col + 1] == key && !isVisited[row][col + 1]) {
            isVisited[row][col + 1] = true;
            flag = DFS(board, k + 1, row, col + 1, word, isVisited);
            isVisited[row][col + 1] = flag | false;
        }

        return flag;
    }

    public void clearIsVisited (boolean[][] isVisited) {
        for (int i = 0; i < isVisited.length; i++) {
            Arrays.fill(isVisited[i], false);
        }
    }

    public static void main (String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word));
    }
}
