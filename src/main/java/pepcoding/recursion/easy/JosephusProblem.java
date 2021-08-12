package pepcoding.recursion.easy;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/josephus-problem-official/ojquestion
 *
 * 1. You are given two numbers N and K.
 * 2. N represents the total number of soldiers standing in a circle having position marked from 0 to N-1.
 * 3. A cruel king wants to execute them but in a different way.
 * 4. He starts executing soldiers from 0th position and proceeds around the circle in clockwise direction.
 * 5. In each step, k-1 soldiers are skipped and the k-th soldier is executed.
 * 6. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed soldiers are removed), until only the last soldier remains, who is given freedom.
 * 7. You have to find the position of that lucky soldier.
 */
public class JosephusProblem {

    public static void main(String[] args) {

        int numOfSoldiers = 4;
        int step = 2;
        int luckySoldierPosition = solution(numOfSoldiers, step);
        System.out.println("position of lucky soldier: " + luckySoldierPosition);

        numOfSoldiers = 7;
        step = 4;
        luckySoldierPosition = solution(numOfSoldiers, step);
        System.out.println("position of lucky soldier: " + luckySoldierPosition);
    }

    private static int solution (int numOfSoldiers, int step) {

        if (numOfSoldiers == 1) {
            return 0;
        }

        int luckySoldierPosition = solution(numOfSoldiers - 1, step);
        int actualPosition = (luckySoldierPosition + step) % numOfSoldiers;
        return actualPosition;
    }
}
