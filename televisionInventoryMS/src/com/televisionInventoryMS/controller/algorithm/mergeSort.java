package com.televisionInventoryMS.controller.algorithm;

import com.televisionInventoryMS.model.inventoryMS;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the merge sort algorithm for sorting inventoryMS objects.
 * Sorts based on the ModelNo field in ascending or descending order.
 * 
 * @author Prithivi
 */
public class mergeSort {
    /**
     * Sorts a list of inventoryMS objects by their ModelNo in ascending or descending order.
     *
     * @param productList the list of inventoryMS objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<inventoryMS> sortByPrice(List<inventoryMS> productList, boolean isDesc) {
        if (productList == null) {
            throw new IllegalArgumentException("Product list cannot be null.");
        }
        if (productList.size() <= 1) {
            return productList; // Already sorted
        }

        // Split the list into two halves
        int mid = productList.size() / 2;
        List<inventoryMS> left = new ArrayList<>(productList.subList(0, mid));
        List<inventoryMS> right = new ArrayList<>(productList.subList(mid, productList.size()));

        // Recursively sort each half
        left = sortByPrice(left, isDesc);
        right = sortByPrice(right, isDesc);

        // Merge the sorted halves
        return merge(left, right, isDesc);
    }

    /**
     * Merges two sorted lists into one sorted list based on the sort order.
     *
     * @param left the first sorted list
     * @param right the second sorted list
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the merged sorted list
     */
    private List<inventoryMS> merge(List<inventoryMS> left, List<inventoryMS> right, boolean isDesc) {
        List<inventoryMS> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge elements from both lists in sorted order
        while (i < left.size() && j < right.size()) {
            if (shouldSwap(left.get(i).getPrice(), right.get(j).getPrice(), isDesc)) {
                merged.add(right.get(j));
                j++;
            } else {
                merged.add(left.get(i));
                i++;
            }
        }

        // Add remaining elements from the left list
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        // Add remaining elements from the right list
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    /**
     * Determines whether the current value from the left list should come after
     * the current value from the right list based on the sort order.
     *
     * @param leftValue the value from the left list
     * @param rightValue the value from the right list
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the right value should come before the left value; false otherwise
     */
    private boolean shouldSwap(int leftValue, int rightValue, boolean isDesc) {
        return isDesc ? leftValue < rightValue : leftValue > rightValue;
    }
}
