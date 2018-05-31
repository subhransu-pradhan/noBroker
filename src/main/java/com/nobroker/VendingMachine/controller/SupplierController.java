package com.nobroker.VendingMachine.controller;

import com.nobroker.VendingMachine.bo.Product;

public interface SupplierController {
    public void addProduct(String code, Product product);
}
