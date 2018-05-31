package com.nobroker.VendingMachine.dao;

import com.nobroker.VendingMachine.bo.Product;

public interface ProductDaoSupplier {
    public void addProduct(String code, Product product);
}
