package com.televisionInventoryMS.controller.algorithm;

import com.televisionInventoryMS.model.inventoryMS;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the insertion sort algorithm for sorting inventoryMS objects.
 * Sorts based on the size field in ascending or descending order.
 * 
 * @author Pratik Man Pradhan
 */
public class insertionSort {
    List<inventoryMS> productSortList;

    public insertionSort() {
        productSortList = new ArrayList<>(); // Creating an array list to hold sorted products.
    }

    
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

    private boolean shouldSwap(int current, int previous, boolean isDesc) {
        return isDesc ? current > previous : current < previous; /** ternary operator return true if swap 
                                                                     is needed, else return false  **/
    }
}
