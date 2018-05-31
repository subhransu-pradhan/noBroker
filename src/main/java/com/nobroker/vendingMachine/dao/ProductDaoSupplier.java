package com.nobroker.vendingMachine.dao;

import com.nobroker.vendingMachine.bo.Product;

public interface ProductDaoSupplier {
    public void addProduct(String code, Product product);
}
