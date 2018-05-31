package com.nobroker.vendingMachine.controller.impl;

import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.service.impl.SupplierServiceImpl;
import com.nobroker.vendingMachine.service.SupplierService;

public class SupplierControllerImpl {
    SupplierService supplierService = new SupplierServiceImpl();

    public void addProduct(String code, Product product) {
        supplierService.addProduct(code, product);
    }

}
