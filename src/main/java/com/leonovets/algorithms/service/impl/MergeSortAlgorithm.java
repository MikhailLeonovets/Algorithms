package com.leonovets.algorithms.service.impl;

import com.leonovets.algorithms.service.ArraysAlgorithm;
import org.springframework.stereotype.Service;

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
        sort(array);
        return array;
    }

    /**
     * Merges two sub-arrays from incoming array
     *
     * @param array       is incoming array which contains sub-arrays
     * @param leftArray   is a left sub-array
     * @param rightArray  is a right sub-array
     * @param leftLength  is left sub-array length
     * @param rightLength is right sub-array length
     */
    private void merge(final int[] array, final int[] leftArray, final int[] rightArray, final int leftLength, final int rightLength) {
        // merge sub-arrays
        // indexes
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * @param array is incoming array
     */
    private void sort(int[] array) {
        int length = array.length;
        if (length < 2) {
            return;
        }

        // calculate middle index
        int middleIndex = length / 2;
        // creates temp arrays for the sub-arrays
        int[] leftArray = new int[middleIndex];
        int[] rightArray = new int[length - middleIndex];

        // populate it
        System.arraycopy(array, 0, leftArray, 0, middleIndex);

        if (length - middleIndex >= 0) System.arraycopy(array, middleIndex, rightArray,
                0, length - middleIndex);

        // sort sub-arrays
        sort(leftArray);
        sort(rightArray);

        //merge them
        merge(array, leftArray, rightArray, middleIndex, length - middleIndex);
    }

}
