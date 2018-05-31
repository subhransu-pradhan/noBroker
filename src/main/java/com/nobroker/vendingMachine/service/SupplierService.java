package com.nobroker.vendingMachine.service;

import com.nobroker.vendingMachine.bo.Product;

public interface SupplierService {
    public void addProduct(String code, Product product);
}
