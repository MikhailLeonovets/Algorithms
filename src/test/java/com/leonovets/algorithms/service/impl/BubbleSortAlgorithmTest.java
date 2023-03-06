package com.leonovets.algorithms.service.impl;

import com.leonovets.algorithms.service.ArraysAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Mikhail.Leonovets
 * @since 03/06/2023 - 13:49
 */
class BubbleSortAlgorithmTest {
    private int[] givenRandomArray;
    private int[] givenArrayWithNegativeArray;
    private int[] givenSortedArray;

    private int[] expectedFromRandomArray;
    private int[] expectedArrayFromNegativeArray;
    private int[] expectedArrayFromSortedArray;

    private ArraysAlgorithm arraysAlgorithm;


    @BeforeEach
    void setUp() {
        givenRandomArray = new int[]{ 0, 24, 114, 10, 0, 478, 137487, 347, 17, 45 };
        givenArrayWithNegativeArray = new int[]{ 0, 24, 114, -10, 0, 478, -137487, -347, 17, 45 };
        givenSortedArray = new int[]{ -344, -24, -10, 0, 0, 478, 45, 347, 1700, 137487 };

        expectedFromRandomArray = new int[]{ 0, 0, 10, 17, 24, 45, 114, 347, 478, 137487 };
        expectedArrayFromNegativeArray = new int[]{ -137487, -347, -10, 0, 0, 17, 24, 45, 114, 478, };
        expectedArrayFromSortedArray = new int[]{ -344, -24, -10, 0, 0, 45, 347, 478, 1700, 137487 };

        arraysAlgorithm = new BubbleSortAlgorithm();
    }

    @Test
    void calculate() {
        // given
        // when
        final int[] actualResultFromRandomArray = arraysAlgorithm.calculate(givenRandomArray);
        final int[] actualResultArrayWithNegativeArray = arraysAlgorithm.calculate(givenArrayWithNegativeArray);
        final int[] actualResultFromSortedArray = arraysAlgorithm.calculate(givenSortedArray);

        // then
        Assertions.assertArrayEquals(expectedFromRandomArray, actualResultFromRandomArray);
        Assertions.assertArrayEquals(expectedArrayFromNegativeArray, actualResultArrayWithNegativeArray);
        Assertions.assertArrayEquals(expectedArrayFromSortedArray, actualResultFromSortedArray);
    }
}