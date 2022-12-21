package com.kenzie.greedy.backpacking;

import java.util.*;

/**
 * Contains a problem that can be solved using the Greedy Technique.
 */
public class Backpacking {

    /**
     * Given a list of snacks with their weight, and a given weight limit, return the maximum number
     * of snacks that you could pack without exceeding the weight limit. Assume you only have one of each snack.
     *
     * Example: [(snackName, weight)]
     * snacks = [(peanuts, 8), (chips, 3), (protein bar, 9), (berries, 7), (banana, 4), (cookies, 10)]
     * weightLimit = 20
     *
     * result = [(chips, 3), (banana, 4), (berries, 7)] -> 3 snacks
     *
     * @param snacks      - the list of snacks from which to identify the maximum snacks to pack
     * @param weightLimit - the maximum weight of snacks we can pack
     * @return the maximum number of snacks we can pack
     */
    public static int getMaximumSnacks(List<Snack> snacks, int weightLimit) {
        // TODO: Implement an algorithm that utilizes the greedy technique
        int remainingWeight = weightLimit;
        Map<Integer, String> snackMap = new TreeMap<Integer, String>();

        for (Snack snack : snacks) {
            int weight = snack.getWeight();
            String name = snack.getName();
            snackMap.put(weight, name);
        }

        Map<Integer, String> sortedSnacks = new TreeMap<Integer, String>(snackMap);
        ArrayList maxSnacks = new ArrayList();

        for (Integer integer : sortedSnacks.keySet()) {
            if (integer <= remainingWeight) {
                maxSnacks.add(integer);
                remainingWeight -= integer;
            } else {
                break;
            }
        }

        return maxSnacks.size();
    }
}
