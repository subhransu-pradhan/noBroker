package com.nobroker.vendingMachine.controller;

import com.nobroker.vendingMachine.bo.Coin;
import com.nobroker.vendingMachine.bo.Product;

import java.util.Map;

public interface VendorController {
    public void addCoin(int value);

    public Product getProduct(String productId);

    public Map<Coin, Integer> returnMoney();

}
