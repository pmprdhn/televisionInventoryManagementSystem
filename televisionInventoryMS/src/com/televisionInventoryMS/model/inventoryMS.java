/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.televisionInventoryMS.model;

/**
 *
 * @author pratikmanpradhan
 */
public class inventoryMS {
    private int modelNo;
    private String company;
    private int size;
    private int price;
    private String resolution;
    private boolean smart;
    private int inStock;
    
    
    
    public inventoryMS(int modelNo, String company, int size, int price, String resolution,boolean smart,int inStock) {
        this.modelNo = modelNo;
        this.company = company;
        this.size = size;
        this.price = price;
        this.resolution = resolution;
        this.smart = smart;
        this.inStock = inStock;
    }
    
    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }    

    public boolean isSmart() {
        return smart;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }
    
    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
}
