package com.nobroker.VendingMachine.service;

import com.nobroker.VendingMachine.bo.Product;

public interface SupplierService {
    public void addProduct(String code, Product product);
}
