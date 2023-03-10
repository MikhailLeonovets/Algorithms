package com.leonovets.algorithms.controller;

import com.leonovets.algorithms.service.ArraysAlgorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mikhail.Leonovets
 * @since 03/10/2023 - 13:03
 */
@RestController
@RequestMapping("/api/sort-array")
public class SortArrayController {
    private final ArraysAlgorithm arraysAlgorithm;

    public SortArrayController(@Qualifier("mergeSortAlgorithm") final ArraysAlgorithm arraysAlgorithm) {
        this.arraysAlgorithm = arraysAlgorithm;
    }



}
