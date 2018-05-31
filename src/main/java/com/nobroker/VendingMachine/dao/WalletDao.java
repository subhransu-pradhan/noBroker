package com.nobroker.VendingMachine.dao;

import com.nobroker.VendingMachine.bo.Coin;

import java.util.Map;

public interface WalletDao {
    public void addCoin(Coin coin);

    public void spendMoney( long value);

    public Map<Coin, Integer> returnChange();
}
