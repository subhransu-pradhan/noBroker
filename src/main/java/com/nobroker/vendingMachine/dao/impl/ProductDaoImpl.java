package com.nobroker.vendingMachine.dao.impl;

import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.bo.VendingMachine;
import com.nobroker.vendingMachine.dao.ProductDaoSupplier;
import com.nobroker.vendingMachine.dao.ProductsDaoCustomer;

public class ProductDaoImpl implements ProductsDaoCustomer, ProductDaoSupplier {

    VendingMachine vendingMachine = VendingMachine.getInstance();

    public Product getProduct(String id)
    {
        return vendingMachine.getProduct(id);
    }

    public void addProduct(String code,Product product)
    {
        vendingMachine.addProduct(code, product);
    }
}
