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
        productSortList = new ArrayList<>(); // Creating ArrayList to store sorted productList
    }
    
    public  List<inventoryMS> sortByCompany(List<inventoryMS> productList, boolean isDesc) {
        this.productSortList.clear(); // Clearing any existing value in productSortList
        this.productSortList.addAll(productList); // Copying all the values of productList to productSortList
        if (productSortList == null || productSortList.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty."); // Throwing exception in case of empty list
        }

        // Sorting the list
        for (int i = 0; i < productSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(productSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(productSortList, i, extremumIndex);
            }
        }

        return productSortList;
    }

   
    private int findExtremumIndex(List<inventoryMS> productSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex; // Initializing extremum index as start index

        // Iterating through the list after start index
        for (int j = startIndex + 1; j < productSortList.size(); j++) {
            
            // comparing company using shouldSwap method
            if (shouldSwap(productSortList.get(j).getCompany(), productSortList.get(extremumIndex).getCompany(), isDesc)) {
                extremumIndex = j;  // Updating extremum index if the above condition is true
            }
        }

        return extremumIndex; // returning extremum Index
    }

    
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        int comparison=current.compareToIgnoreCase(extremum);
        return isDesc ? comparison > 0 : comparison < 0;/** ternary operator return true if current 
                                                                      should replace extremum else false  **/
    }

   
    private void swap(List<inventoryMS> productSortList, int i, int j) {
        
        // Exchanging places of element at index i and j 
        inventoryMS temp = productSortList.get(i);
        productSortList.set(i, productSortList.get(j));
        productSortList.set(j, temp);
    }
}