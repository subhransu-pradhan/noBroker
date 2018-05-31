package com.nobroker.VendingMachine.dao.impl;

import com.nobroker.VendingMachine.bo.Product;
import com.nobroker.VendingMachine.bo.VendingMachine;
import com.nobroker.VendingMachine.dao.ProductDaoSupplier;
import com.nobroker.VendingMachine.dao.ProductsDaoCustomer;

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
