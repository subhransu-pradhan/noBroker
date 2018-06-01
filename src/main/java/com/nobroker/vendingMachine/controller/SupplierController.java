package com.nobroker.vendingMachine.controller;

import com.nobroker.vendingMachine.bo.Product;

public interface SupplierController {
    public void addProduct(String code, String productName, long price, int quantity);
}
