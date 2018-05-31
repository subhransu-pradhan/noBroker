package com.nobroker.vendingMachine.controller.impl;

import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.service.VendorService;
import com.nobroker.vendingMachine.service.impl.VendorServiceImpl;
import com.nobroker.vendingMachine.bo.Coin;

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
