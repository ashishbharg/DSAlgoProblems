package pepcoding.recursion.hard;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/solve-sudoku-official/ojquestion
 *
 * 1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
 * 2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
 * Rule 1 -> Digits from 1-9 must occur exactly once in each row.
 * Rule 2 -> Digits from 1-9 must occur exactly once in each column.
 * Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.
 *
 * Assumption -> The given Sudoku puzzle will have a single unique solution.
 */
public class Sudoku {

    public static void main(String[] args) {

        int[][] board = new int[][] {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        solveSudoku(board, 0, 0);
    }

    private static void display(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solveSudoku(int[][] board, int i, int j) {

        if (i == board.length) {
            display(board);
            return;
        }

        int ni;
        int nj;

        if (j < board[0].length - 1) {
            ni = i;
            nj = j + 1;
        } else {
            ni = i + 1;
            nj = 0;
        }

        if (board[i][j] != 0) {
            solveSudoku(board, ni, nj);
        } else {
            for (int val = 1; val <= 9; val++) {
                if (isValid(board, i, j, val)) {
                    board[i][j] = val;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean isValid(int[][] board, int i, int j, int val) {

        // check for value in columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[i][col] == val) {
                return false;
            }
        }

        // check for value in rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][j] == val) {
                return false;
            }
        }

        // check for value in sub-matrix

        /*
            4, 7
           subMatrixRowStart = 3
           subMatrixColStart = 6
           3,6 3,7 3,8
           4,6 4,7 4,8
           5,6 5,7 5,8
         */
        int subMatrixRowStart = (i / 3) * 3;
        int subMatrixColStart = (j / 3) * 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[subMatrixRowStart + row][subMatrixColStart + col] == val) {
                    return false;
                }
            }
        }
        return true;
    }

}
