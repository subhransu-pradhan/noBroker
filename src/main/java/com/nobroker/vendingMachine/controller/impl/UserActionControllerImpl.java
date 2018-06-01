package com.nobroker.vendingMachine.controller.impl;

import com.nobroker.vendingMachine.bo.Coin;
import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.controller.SupplierController;
import com.nobroker.vendingMachine.controller.VendorController;
import com.nobroker.vendingMachine.service.VendorService;
import com.nobroker.vendingMachine.service.impl.SupplierServiceImpl;
import com.nobroker.vendingMachine.service.SupplierService;
import com.nobroker.vendingMachine.service.impl.VendorServiceImpl;

import java.util.Map;

public class UserActionControllerImpl implements SupplierController, VendorController{
    SupplierService supplierService = new SupplierServiceImpl();

    VendorService vendorService = new VendorServiceImpl();

    public void addCoin(int value) {
        vendorService.addCoin(Coin.getInstance(value));
    }

    public Product getProduct(String productId) {
        return vendorService.getProduct(productId);
    }

    public Map<Coin, Integer> returnMoney(){
        return vendorService.returnMoney();
    }

    public void addProduct(String code, String productName, long price, int quantity) {
        supplierService.addProduct(code, new Product(productName, price, quantity));
    }

}
