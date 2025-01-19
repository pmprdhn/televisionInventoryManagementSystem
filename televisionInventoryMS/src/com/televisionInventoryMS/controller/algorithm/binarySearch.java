/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.televisionInventoryMS.controller.algorithm;

import com.televisionInventoryMS.model.inventoryMS;
import java.util.List;

/**
 *
 * @author Pratik Man Pradhan
 */
public class binarySearch {

    public inventoryMS searchByCompany(String searchValue, List<inventoryMS> productList,
            int left, int right) {

        // Base Case
        if (right < left) {
            return null;
        }

        // mid value
        int mid = (left + right) / 2;

        // checks whether searchKey lies on mid point
        if (searchValue.compareToIgnoreCase(productList.get(mid).getCompany()) == 0) {
            return productList.get(mid);
        // searching searchKey on the left
        } else if (searchValue.compareToIgnoreCase(productList.get(mid).getCompany()) < 0) {
            return searchByCompany(searchValue, productList, left, mid - 1);
        // searching searchKey on the right
        } else {
            return searchByCompany(searchValue, productList, mid + 1, right);
        }

    }
}