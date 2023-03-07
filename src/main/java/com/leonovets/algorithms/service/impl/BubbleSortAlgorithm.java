package com.leonovets.algorithms.service.impl;

import com.leonovets.algorithms.service.ArraysAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * @author Mikhail.Leonovets
 * @since 03/06/2023 - 13:42
 */
@Service
public class BubbleSortAlgorithm implements ArraysAlgorithm {

    @Override
    public int[] calculate(final int[] incomingData) {
        if (incomingData.length <= 1) {
            return incomingData;
        }

        final int[] array = Arrays.copyOf(incomingData, incomingData.length);
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    final int buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                }
            }
        }
        return array;
    }

}
