package pepcoding.recursion.hard;

/**
 * 1. You are given a number n, the size of a chess board.
 * 2. You are required to place n number of queens in the n * n cells of board such that no queen can
 *      kill another.
 * Note - Queens kill at distance in all 8 directions
 *
 * This is done via branch and bound technique.
 */
public class NQueensProblemBranchAndBoundApproach {

    public static void main(String[] args) {
        int boardLength = 4;

        boolean[][] board = new boolean[boardLength][boardLength];
        boolean[] cols = new boolean[boardLength];

        // Diagonals in a square array will always be 2 * n - 1
        boolean[] normalDiagonal = new boolean[2 * boardLength - 1];
        boolean[] reverseDiagonal = new boolean[2 * boardLength - 1];
        solve(board, 0, cols, normalDiagonal, reverseDiagonal, "");
    }

    private static void solve(boolean[][] board, int row, boolean[] cols, boolean[] normalDiagonal,
                              boolean[] reverseDiagonal, String ans) {

        int boardLength = board.length;
        if (row == boardLength) {
            System.out.println(ans);
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (!cols[col] && !normalDiagonal[row + col] && !reverseDiagonal[row - col + boardLength - 1]) {
                board[row][col] = true;
                cols[col] = true;
                normalDiagonal[row + col] = true;
                reverseDiagonal[row - col + boardLength - 1] = true;
                solve(board, row + 1, cols, normalDiagonal, reverseDiagonal, ans + row + "-" + col + ", ");
                reverseDiagonal[row - col + boardLength - 1] = false;
                normalDiagonal[row + col] = false;
                cols[col] = false;
                board[row][col] = false;
            }
        }

    }
}
