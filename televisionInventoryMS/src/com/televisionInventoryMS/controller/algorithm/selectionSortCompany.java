package com.televisionInventoryMS.controller.algorithm;

import com.televisionInventoryMS.model.inventoryMS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pratik Man Pradhan
 */
public class selectionSortCompany {
    List<inventoryMS> productSortList;

    
    public selectionSortCompany(){
        productSortList = new ArrayList<>();
    }
    /**
     * Sorts a list of StudentModel objects by their LMU ID in ascending or
     * descending order.
     *
     * @param productList the list of StudentModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public  List<inventoryMS> sortByCompany(List<inventoryMS> productList, boolean isDesc) {
        this.productSortList.clear();
        this.productSortList.addAll(productList);
        if (productSortList == null || productSortList.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty.");
        }

        for (int i = 0; i < productSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(productSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(productSortList, i, extremumIndex);
            }
        }

        return productSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param studentSortList the list of StudentModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<inventoryMS> productSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < productSortList.size(); j++) {
            if (shouldSwap(productSortList.get(j).getCompany(), productSortList.get(extremumIndex).getCompany(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        int comparison=current.compareToIgnoreCase(extremum);
        return isDesc ? comparison > 0 : comparison < 0;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param studentSortList the list of StudentModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<inventoryMS> productSortList, int i, int j) {
        inventoryMS temp = productSortList.get(i);
        productSortList.set(i, productSortList.get(j));
        productSortList.set(j, temp);
    }
}