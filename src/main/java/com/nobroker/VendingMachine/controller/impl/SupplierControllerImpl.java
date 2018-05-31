package com.nobroker.VendingMachine.controller.impl;

import com.nobroker.VendingMachine.bo.Product;
import com.nobroker.VendingMachine.service.impl.SupplierServiceImpl;
import com.nobroker.VendingMachine.service.SupplierService;

public class SupplierControllerImpl {
    SupplierService supplierService = new SupplierServiceImpl();

    public void addProduct(String code, Product product) {
        supplierService.addProduct(code, product);
    }

}
