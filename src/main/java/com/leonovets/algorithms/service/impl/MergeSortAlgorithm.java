package com.leonovets.algorithms.service.impl;

import com.leonovets.algorithms.service.ArraysAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * @author Mikhail.Leonovets
 * @since 03/06/2023 - 14:19
 */
@Service
public class MergeSortAlgorithm implements ArraysAlgorithm {

    @Override
    public int[] calculate(final int[] incomingData) {
        if (incomingData.length <= 1) {
            return incomingData;
        }

        final int[] array = Arrays.copyOf(incomingData, incomingData.length);
        sort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Merges two sub-arrays from incoming array
     *
     * @param array       is incoming array which contains sub-arrays
     * @param leftIndex   is left element index in the array to be merged
     * @param middleIndex is middle element index between two sub-arrays in the array
     * @param rightIndex  is right element index
     */
    private void merge(final int[] array, int leftIndex, int middleIndex, int rightIndex) {
        // creates temp arrays for the sub-arrays
        int[] leftArray = Arrays.copyOfRange(array, leftIndex, middleIndex);
        int[] rightArray = Arrays.copyOfRange(array, middleIndex + 1, rightIndex);

        // merge sub-arrays
        // indexes
        int i = 0;
        int j = 0;
        int k = leftIndex;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < rightArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < leftArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * @param array      is incoming array
     * @param leftIndex  is left index of sub-array
     * @param rightIndex is right index of sub-array
     */
    private void sort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            sort(array, leftIndex, middleIndex);
            sort(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

}
