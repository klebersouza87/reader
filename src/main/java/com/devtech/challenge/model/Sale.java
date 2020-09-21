package com.devtech.challenge.model;

public class Sale {

    private int id;
    private int SaleId;
    private String itemIdItemQuantityItemPrice;
    private String salesmanName;
    private double totalSale;

    public Sale(int id, int saleId, String itemIdItemQuantityItemPrice, String salesmanName) {
        this.id = id;
        SaleId = saleId;
        this.itemIdItemQuantityItemPrice = itemIdItemQuantityItemPrice;
        this.salesmanName = salesmanName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaleId() {
        return SaleId;
    }

    public void setSaleId(int saleId) {
        SaleId = saleId;
    }

    public String getItemIdItemQuantityItemPrice() {
        return itemIdItemQuantityItemPrice;
    }

    public void setItemIdItemQuantityItemPrice(String itemIdItemQuantityItemPrice) {
        this.itemIdItemQuantityItemPrice = itemIdItemQuantityItemPrice;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale += totalSale;
    }

    public double getTotalSale() {
        return totalSale;
    }
}
