package com.nobroker.VendingMachine.controller.impl;

import com.nobroker.VendingMachine.bo.Product;
import com.nobroker.VendingMachine.service.VendorService;
import com.nobroker.VendingMachine.service.impl.VendorServiceImpl;
import com.nobroker.VendingMachine.bo.Coin;

import java.util.Map;

public class VendorControllerImpl {
    VendorService vendorService = new VendorServiceImpl();

    public void addCoin(Coin coin) {
        vendorService.addCoin(coin);
    }

    public Product getProduct(String productId) {
        return vendorService.getProduct(productId);
    }

    public Map<Coin, Integer> returnMoney(){
        return vendorService.returnMoney();
    }
}
