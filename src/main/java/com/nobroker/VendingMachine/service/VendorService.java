package com.nobroker.VendingMachine.service;

import com.nobroker.VendingMachine.bo.Product;
import com.nobroker.VendingMachine.bo.Coin;

import java.util.Map;

public interface VendorService {
    public void addCoin(Coin coin);

    public Product getProduct(String productId);

    public Map<Coin, Integer> returnMoney();
}
