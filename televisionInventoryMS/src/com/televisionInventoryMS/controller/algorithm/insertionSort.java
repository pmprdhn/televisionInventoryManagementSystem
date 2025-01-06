package com.televisionInventoryMS.controller.algorithm;

import com.televisionInventoryMS.model.inventoryMS;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the insertion sort algorithm for sorting inventoryMS objects.
 * Sorts based on the ModelNo field in ascending or descending order.
 * 
 * @author Prithivi
 */
public class insertionSort {
    List<inventoryMS> productSortList;

    public insertionSort() {
        productSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of inventoryMS objects by their Size in ascending or descending order.
     *
     * @param productList the list of inventoryMS objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<inventoryMS> sortBySize(List<inventoryMS> productList, boolean isDesc) {
        if (productList == null) {
            throw new IllegalArgumentException("Product list cannot be null.");
        }

        this.productSortList.clear();
        this.productSortList.addAll(productList);

        for (int i = 1; i < productSortList.size(); i++) {
            inventoryMS current = productSortList.get(i);
            int j = i - 1;

            // Compare current element with the sorted portion and shift elements
            while (j >= 0 && shouldSwap(current.getSize(), productSortList.get(j).getSize(), isDesc)) {
                productSortList.set(j + 1, productSortList.get(j)); // Shift element to the right
                j--;
            }

            // Insert the current element at its correct position
            productSortList.set(j + 1, current);
        }

        return productSortList;
    }

    /**
     * Determines whether the current value should be placed before the existing value based on the sort order.
     *
     * @param current the current value
     * @param previous the previous value
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current value should come before the previous value; false otherwise
     */
    private boolean shouldSwap(int current, int previous, boolean isDesc) {
        return isDesc ? current > previous : current < previous;
    }
}
