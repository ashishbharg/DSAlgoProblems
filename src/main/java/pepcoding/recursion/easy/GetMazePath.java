package pepcoding.recursion.easy;

import java.util.ArrayList;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-maze-paths-official/ojquestion
 *
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
 * 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
 * 3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
 */
public class GetMazePath {

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

        ArrayList<String> horizontalMazePaths;
        ArrayList<String> verticalMazePaths;
        ArrayList<String> result = new ArrayList<>();
        if (startCol < destCol) {
            horizontalMazePaths = getMazePaths(startRow, startCol + 1, destRow, destCol);
            for (String str : horizontalMazePaths) {
                result.add("h" + str);
            }
        }

        if (startRow < destRow) {
            verticalMazePaths = getMazePaths(startRow + 1, startCol, destRow, destCol);
            for (String str : verticalMazePaths) {
                result.add("v" + str);
            }
        }
        return result;
    }
}
