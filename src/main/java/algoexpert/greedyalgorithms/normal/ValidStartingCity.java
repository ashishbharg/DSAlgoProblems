package algoexpert.greedyalgorithms.normal;

/**
 * Imagine you have a set of cities that are laid out in circle, connected by a circular road that runs clockwise. Each
 * city has a gas station that provides gallons of fuel, and each city is distance away from the next city.
 *
 * You have a car that can drive some number of miles per gallon of fuel, and your goal is to pick a starting city such
 * that you can fill up your car with that city's fuel, drive to the next city, refill up your car with that city's fuel,
 * drive to the next city, and so on and so forth until you return back to the starting city with 0 or more gallons of fuel
 * left.
 *
 * This city is called validstarting city, and its guaranteed that there will always be exactly one valid starting city.
 *
 * For the actual problem, you'll be given an array of distances such that city i is distances[i] away from city i + 1.
 * Since the cities are connected via a circular road, the last city is connected to the first city. In other words, the
 * last distance in the distances array is equal to the distance from last city to the first city. You'll also be given
 * an array of fuel available at each city, where fuel[i] is equal to the fuel available at city i. The total amount of
 * fuel available is exactly enough to travel to all cities. Your fuel tank always starts out empty, and you're given a
 * positive integer value for the number of miles that your car can travel per gallon of fuel. You can assume that you will
 * always be given at least two cities.
 *
 * Write a function that return the index of the valid starting city.
 *
 * Example:
 * distances: [5, 25, 15, 10, 15],
 * fuel: [1, 2, 1, 0, 3],
 * mpg: 10
 * Output: 4
 *
 */
public class ValidStartingCity {

    public static void main(String[] args) {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int validStartingCityIndex = validStartingCity(distances, fuel, mpg);
        assert 4 == validStartingCityIndex;

        distances = new int[] {10, 20, 10, 15, 5, 15, 25};
        fuel = new int[] {0, 2, 1, 0, 0, 1, 1};
        mpg = 20;
        validStartingCityIndex = validStartingCity(distances, fuel, mpg);
        assert 1 == validStartingCityIndex;

        distances = new int[] {30, 40, 10, 10, 17, 13, 50, 30, 10, 40};
        fuel = new int[] {10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        mpg = 25;
        validStartingCityIndex = validStartingCity(distances, fuel, mpg);
        assert 0 == validStartingCityIndex;
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {

        int milesRemaining = 0;
        int startingIndexCandidate = 0;
        int milesRemainingAtStartingIndexCandidate = 0;
        for (int i = 1; i < distances.length; i++) {

            int distanceFromPreviousCity = distances[i - 1];
            int fuelFromPreviousCity = fuel[i - 1];
            milesRemaining += fuelFromPreviousCity * mpg - distanceFromPreviousCity;

            if (milesRemaining < milesRemainingAtStartingIndexCandidate) {
                milesRemainingAtStartingIndexCandidate = milesRemaining;
                startingIndexCandidate = i;
            }
        }
        return startingIndexCandidate;
    }
}
