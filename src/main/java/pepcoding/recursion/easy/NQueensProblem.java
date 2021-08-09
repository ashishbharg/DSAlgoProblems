package pepcoding.recursion.easy;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/n-queens-official/ojquestion
 *
 * 1. You are given a number n, the size of a chess board.
 * 2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
 * Note - Queens kill at distance in all 8 directions
 * 3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe
 * configurations of n-queens. Use sample input and output to get more idea.
 *
 * This is done via backtracking.
 */
public class NQueensProblem {

    public static void main(String[] args) {

        int chessBoardSize = 4;
        int[][] chess = new int[chessBoardSize][chessBoardSize];
        printNQueens(chess, 0, "");
    }

    private static void printNQueens(int[][] chess, int row, String ans) {

        if (row == chess.length) {
            System.out.println(ans);
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (isQueenSafe(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, row + 1, ans + row + "-" + col + ", ");
                chess[row][col] = 0;
            }
        }
    }

    // We are checking if the queen is either present in same column, diagonally in left upper side or diagonally in
    // right upper side. We don't need to check horizontally or downwards as we are filling up queens row by row.
    private static boolean isQueenSafe(int[][] chess, int row, int col) {

        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
