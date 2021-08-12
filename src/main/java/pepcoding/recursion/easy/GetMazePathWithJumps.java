package pepcoding.recursion.easy;

import java.util.ArrayList;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-maze-path-with-jumps-official/ojquestion
 *
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
 * 2. You are standing in the top-left corner and have to reach the bottom-right corner.
 * 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
 * 4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
 */
public class GetMazePathWithJumps {

    public static void main(String[] args) {

        int rows = 3;
        int cols = 3;
        ArrayList<String> mazePaths = getMazePaths(1, 1, rows, cols);
        System.out.println(mazePaths);
    }

    private static ArrayList<String> getMazePaths(int startRow, int startCol, int destRow, int destCol) {

        if (startRow == destRow && startCol == destCol) {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        ArrayList<String> result = new ArrayList<>();
        // horizontal moves
        for (int hzJump = 1; startCol + hzJump <= destCol; hzJump++) {
            ArrayList<String> horizontalMazePaths = getMazePaths(startRow, startCol + hzJump, destRow, destCol);
            for (String str : horizontalMazePaths) {
                result.add("h" + hzJump + str);
            }
        }

        // vertical moves
        for (int vtJump = 1; startRow + vtJump <= destRow; vtJump++) {
            ArrayList<String> verticalMazePaths = getMazePaths(startRow + vtJump, startCol, destRow, destCol);
            for (String str : verticalMazePaths) {
                result.add("v" + vtJump + str);
            }
        }

        // diagonal moves
        for (int dgJump = 1; startRow + dgJump <= destRow && startCol + dgJump <= destCol; dgJump++) {
            ArrayList<String> diagonalMazePaths = getMazePaths(startRow + dgJump, startCol + dgJump, destRow, destCol);
            for (String str : diagonalMazePaths) {
                result.add("d" + dgJump + str);
            }
        }
        return result;
    }
}