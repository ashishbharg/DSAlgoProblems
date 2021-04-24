package algoexpert.arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * There's an algorithm tournament taking place in which team of programmers compete against each other to solve algorithmic
 * problems as fast as possible. Teams compete in round-robin fashion where each team faces off against all other teams.
 * Only two teams compete against each other at a time, and for each competition, one team is designated as home team, while
 * the other team is designated as away team. In each competition, there is always one winner and one loser; there are no
 * ties. A team receives 3 points if it wins and 0 points if it loses. The winner of the tournament is the team that receives
 * the most amount of points.
 *
 * Given an array of pairs representing the teams that have competed against each other and an array containing the results
 * of each competition, write a function that returns the winner of the tournament. The input arrays are named "competitions"
 * and "results" respectively. The competitions array has elements in the form of [homeTeam, awayTeam], where each team is a
 * string of at most 30 characters representing the name of the team. The results array contains the information about the
 * winner of each corresponding competition in the competitions array. Specifically, results[i] denotes the winner of the
 * competitions[i], where a "1" in the results array means the home team in the corresponding competition won and a "0" means
 * that the away team won.
 *
 * It's guaranteed that exactly one team will win the tournament and that each team will compete against all other teams exactly
 * once. It's also guaranteed that the tournament will always have at least two teams.
 */
public class TournamentWinner {

    public static void main(String[] args) {

        String[][] competitions = new String[][] {{"HTML", "C#"}, {"C#", "Python"}, {"Python", "HTML"}};
        int[] results = new int[] {0, 0, 1};

        String competitionWinner = tournamentWinner(competitions, results);
        assert competitionWinner.equals("Python");

        competitions = new String[][] {{"HTML", "Java"}, {"Java", "Python"}, {"Python", "HTML"}, {"C#", "Python"}, {"Java", "C#"}, {"C#", "HTML"},
                {"SQL", "C#"}, {"HTML", "SQL"}, {"SQL", "Python"}, {"SQL", "Java"}};
        results = new int[] {0, 0, 0, 0, 0, 0, 1, 0, 1, 1};
        competitionWinner = tournamentWinner(competitions, results);
        assert competitionWinner.equals("SQL");
    }

    // Time complexity - O(n) where n is the number of competitions
    // Space complexity - O(k) where k is the number of teams
    public static String tournamentWinner(String[][] competitions, int[] results) {

        String currentBestTeam = "";

        String[] competition;
        String homeTeam, awayTeam, winningTeam;
        Map<String, Integer> scores = new HashMap<>();
        for (int i = 0; i < results.length; i++) {

            competition = competitions[i];
            homeTeam = competition[0];
            awayTeam = competition[1];

            winningTeam = results[i] == 0 ? awayTeam : homeTeam;

            scores.put(winningTeam, scores.getOrDefault(winningTeam, 0) + 3);

            if (currentBestTeam.isEmpty() || scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }

        }
        return currentBestTeam;
    }
}
