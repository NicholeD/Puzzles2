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
        Collections.sort(snacks, new Comparator<Snack>() {
            public int compare(Snack o1, Snack o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        int maxSnacks = 0;
        int currentWeight = 0;

        for (Snack snack : snacks) {
            if (currentWeight + snack.getWeight() <= weightLimit) {
                maxSnacks++;
                currentWeight += snack.getWeight();
            }
        }

        return maxSnacks;
    }

    /** HELPERS */
    private static int getWeight(String snack) {
        int start = snack.indexOf("(");
        int end = snack.indexOf(")");
        return Integer.parseInt(snack.substring(start + 1, end));
    }
}
