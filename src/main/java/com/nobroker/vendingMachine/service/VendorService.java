package com.nobroker.vendingMachine.service;

import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.bo.Coin;

import java.util.Map;

public interface VendorService {
    public void addCoin(Coin coin);

    public Product getProduct(String productId);

    public Map<Coin, Integer> returnMoney();
}
