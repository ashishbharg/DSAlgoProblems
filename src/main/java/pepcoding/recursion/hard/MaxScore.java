package pepcoding.recursion.hard;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/max-score-official/ojquestion
 *
 * 1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet
 *      from a to z.
 * 2. You have to find the maximum score of any valid set of words formed by using the given
 *      alphabets.
 * 3. A word can not be used more than one time.
 * 4. Each alphabet can be used only once.
 * 5. It is not necessary to use all the given alphabets.
 */
public class MaxScore {

    public static void main(String[] args) {

        String[] words = new String[] {"dog", "cat", "dad", "good"};
        char[] lettersAllowed = new char[] {'a', 'b', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] letterWeightage = new int[] {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] charFrequency = new int[26];
        for (char ch: lettersAllowed) {
            charFrequency[ch - 'a']++;
        }
        int maxScore = getMaxScore(words, charFrequency, letterWeightage, 0);
        System.out.println("Max Score: " + maxScore);
    }

    // going with level & options and backtracking technique
    private static int getMaxScore(String[] words, int[] charFrequency, int[] letterWeightage, int index) {

        if (index == words.length) {
            return 0;
        }

        int noScore = getMaxScore(words, charFrequency, letterWeightage, index + 1);

        String word = words[index];
        int wordScore = 0;
        boolean flag = true;
        for (char ch : word.toCharArray()) {

            if (charFrequency[ch - 'a'] == 0) {
                flag = false;
            }
            charFrequency[ch - 'a']--;

            wordScore += letterWeightage[ch - 'a'];
        }

        int yesScore = 0;
        if (flag) {
            yesScore = wordScore + getMaxScore(words, charFrequency, letterWeightage, index + 1);
        }

        for (char ch: word.toCharArray()) {
            charFrequency[ch - 'a']++;
        }

        return Math.max(noScore, yesScore);
    }
}
