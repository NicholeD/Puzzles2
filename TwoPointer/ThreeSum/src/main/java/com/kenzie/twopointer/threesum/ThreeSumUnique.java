package com.kenzie.twopointer.threesum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contains a problem that can be solved using the Two-Pointer Technique.
 */
public class ThreeSumUnique {
    /**
     * Given an unsorted integer array nums, where each element is unique, return all the triplets
     * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Example:
     *  nums = [-1,0,1,3,2,-4]
     *  result = [[-4,1,3],[-1,0,1]]
     *
     * @param nums an unsorted integer array where each element is unique.
     * @return all triplets that sum to 0
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .flatMap(i -> Arrays.stream(nums)
                        .filter(j -> j!=i)
                        .boxed()
                        .flatMap(j -> Arrays.stream(nums)
                                .filter(k -> k != j && k != i)
                                .filter(k -> i + j + k == 0)
                                .boxed()
                                .map(k ->List.of(i, j, k))
                    )
                )
                .collect(Collectors.toList());
    }
}
