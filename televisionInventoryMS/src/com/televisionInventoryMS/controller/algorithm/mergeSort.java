package com.televisionInventoryMS.controller.algorithm;

import com.televisionInventoryMS.model.inventoryMS;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the merge sort algorithm for sorting inventoryMS objects.
 * Sorts based on the Price field in ascending or descending order.
 * 
 * @author Pratik Man Pradhan
 */
public class mergeSort {
    
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

    private boolean shouldSwap(int leftValue, int rightValue, boolean isDesc) {
        return isDesc ? leftValue < rightValue : leftValue > rightValue;
    }
}
