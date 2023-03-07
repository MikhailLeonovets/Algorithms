package com.leonovets.algorithms.service.impl;

import com.leonovets.algorithms.service.ArraysAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Mikhail.Leonovets
 * @since 03/07/2023 - 15:32
 */
class MergeSortAlgorithmTest {
    private int[] givenRandomArray;
    private int[] givenArrayWithNegativeArray;
    private int[] givenSortedArray;

    private int[] expectedFromRandomArray;
    private int[] expectedArrayFromNegativeArray;
    private int[] expectedArrayFromSortedArray;

    private ArraysAlgorithm mergeSortAlgorithm;

    @BeforeEach
    void setUp() {
        givenRandomArray = new int[]{ 0, 24, 114, 10, 0, 478, 137487, 347, 17, 45 };
        givenArrayWithNegativeArray = new int[]{ 0, 24, 114, -10, 0, 478, -137487, -347, 17, 45 };
        givenSortedArray = new int[]{ -344, -24, -10, 0, 0, 478, 45, 347, 1700, 137487 };

        expectedFromRandomArray = new int[]{ 0, 0, 10, 17, 24, 45, 114, 347, 478, 137487 };
        expectedArrayFromNegativeArray = new int[]{ -137487, -347, -10, 0, 0, 17, 24, 45, 114, 478, };
        expectedArrayFromSortedArray = new int[]{ -344, -24, -10, 0, 0, 45, 347, 478, 1700, 137487 };

        mergeSortAlgorithm = new MergeSortAlgorithm();
    }

    @Test
    void testCalculateRandomArray() {
        // given
        // when
        final int[] actualResultFromRandomArray = mergeSortAlgorithm.calculate(givenRandomArray);

        // then
        Assertions.assertArrayEquals(expectedFromRandomArray, actualResultFromRandomArray);
    }

    @Test
    void testCalculateArrayWithNegativeArray() {
        // given
        // when
        final int[] actualResultArrayWithNegativeArray = mergeSortAlgorithm.calculate(givenArrayWithNegativeArray);

        // then
        Assertions.assertArrayEquals(expectedArrayFromNegativeArray, actualResultArrayWithNegativeArray);
    }

    @Test
    void testCalculateSortedArray() {
        // given
        // when
        final int[] actualResultFromSortedArray = mergeSortAlgorithm.calculate(givenSortedArray);

        // then
        Assertions.assertArrayEquals(expectedArrayFromSortedArray, actualResultFromSortedArray);
    }
}