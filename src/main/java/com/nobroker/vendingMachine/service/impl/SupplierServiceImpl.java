package com.nobroker.vendingMachine.service.impl;

import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.dao.ProductDaoSupplier;
import com.nobroker.vendingMachine.dao.impl.ProductDaoImpl;
import com.nobroker.vendingMachine.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

    ProductDaoSupplier productsDao = new ProductDaoImpl();

    public void addProduct(String code, Product product) {
        productsDao.addProduct( code, product);
    }
}
