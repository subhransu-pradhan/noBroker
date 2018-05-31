package com.nobroker.vendingMachine.dao;

import com.nobroker.vendingMachine.bo.Coin;

import java.util.Map;

public interface WalletDao {
    public void addCoin(Coin coin);

    public void spendMoney( long value);

    public Map<Coin, Integer> returnChange();
}
