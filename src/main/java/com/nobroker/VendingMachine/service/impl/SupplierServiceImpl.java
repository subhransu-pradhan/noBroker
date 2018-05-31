package com.nobroker.VendingMachine.service.impl;

import com.nobroker.VendingMachine.bo.Product;
import com.nobroker.VendingMachine.dao.ProductDaoSupplier;
import com.nobroker.VendingMachine.dao.impl.ProductDaoImpl;
import com.nobroker.VendingMachine.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

    ProductDaoSupplier productsDao = new ProductDaoImpl();

    public void addProduct(String code, Product product) {
        productsDao.addProduct( code, product);
    }
}
