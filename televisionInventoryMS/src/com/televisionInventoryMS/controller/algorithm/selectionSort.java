package com.televisionInventoryMS.controller.algorithm;
import com.televisionInventoryMS.model.inventoryMS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pratik Man Pradhan
 */
public class selectionSort {
    List<inventoryMS> productSortList;

    
    public selectionSort(){
        productSortList = new ArrayList<>();
    }
    
    public  List<inventoryMS> sortByModelNo(List<inventoryMS> productList, boolean isDesc) {
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

   
    private int findExtremumIndex(List<inventoryMS> productSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < productSortList.size(); j++) {
            if (shouldSwap(productSortList.get(j).getModelNo(), productSortList.get(extremumIndex).getModelNo(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    private void swap(List<inventoryMS> productSortList, int i, int j) {
        inventoryMS temp = productSortList.get(i);
        productSortList.set(i, productSortList.get(j));
        productSortList.set(j, temp);
    }
}