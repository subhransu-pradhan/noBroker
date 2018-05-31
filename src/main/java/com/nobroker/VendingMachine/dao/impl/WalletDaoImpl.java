package com.nobroker.VendingMachine.dao.impl;

import com.nobroker.VendingMachine.bo.VendingMachine;
import com.nobroker.VendingMachine.dao.WalletDao;
import com.nobroker.VendingMachine.bo.Coin;

import java.util.HashMap;
import java.util.Map;

public class WalletDaoImpl implements WalletDao {

    VendingMachine vendingMachine = VendingMachine.getInstance();

    public void addCoin(Coin coin){
        vendingMachine.addCoins(coin);
    }

    public void spendMoney( long value){
        vendingMachine.setTotalDeposit(vendingMachine.getTotalDeposit() - value);
    }
    
    public Map<Coin, Integer> returnChange(){
        long totalDeposit = vendingMachine.getTotalDeposit();
        Map<Coin, Integer> vendingMachineCoins = vendingMachine.getCoins();
        
        Map<Coin, Integer> coins = new HashMap<Coin, Integer>();
        int countOf25 = (int) ((totalDeposit/25) > vendingMachineCoins.get(Coin.getInstance(25))?vendingMachineCoins.get(Coin.getInstance(25)):totalDeposit/25);
        totalDeposit = totalDeposit - (25 * countOf25);

        int countOf20 = (int) ((totalDeposit/20) > vendingMachineCoins.get(Coin.getInstance(20))?vendingMachineCoins.get(Coin.getInstance(20)):totalDeposit/20);
        totalDeposit = totalDeposit - (20 * countOf20);

        int countOf10 = (int) ((totalDeposit/10) > vendingMachineCoins.get(Coin.getInstance(10))?vendingMachineCoins.get(Coin.getInstance(10)):totalDeposit/10);
        totalDeposit = totalDeposit - (10 * countOf10);

        int countOf5 = (int) ((totalDeposit/5) > vendingMachineCoins.get(Coin.getInstance(5))?vendingMachineCoins.get(Coin.getInstance(5)):totalDeposit/5);
        totalDeposit = totalDeposit - (5 * countOf5);

        int countOf1 = (int) ((totalDeposit/1) > vendingMachineCoins.get(Coin.getInstance(1))?vendingMachineCoins.get(Coin.getInstance(1)):totalDeposit/1);
        totalDeposit = totalDeposit - (1 * countOf1);

        if(totalDeposit > 0){
            throw new RuntimeException("Don't have enough cash.");
        }

        coins.put(Coin.getInstance(25), countOf25);
        coins.put(Coin.getInstance(20), countOf20);
        coins.put(Coin.getInstance(10), countOf10);
        coins.put(Coin.getInstance(5), countOf5);
        coins.put(Coin.getInstance(1), countOf1);

        vendingMachineCoins.put(Coin.getInstance(25), vendingMachineCoins.get(Coin.getInstance(25))-countOf25);
        vendingMachineCoins.put(Coin.getInstance(20), vendingMachineCoins.get(Coin.getInstance(20))-countOf20);
        vendingMachineCoins.put(Coin.getInstance(10), vendingMachineCoins.get(Coin.getInstance(10))-countOf10);
        vendingMachineCoins.put(Coin.getInstance(5), vendingMachineCoins.get(Coin.getInstance(5))-countOf5);
        vendingMachineCoins.put(Coin.getInstance(1), vendingMachineCoins.get(Coin.getInstance(1))-countOf1);

        vendingMachine.setCoins(vendingMachineCoins);
        vendingMachine.setTotalDeposit(totalDeposit);

        return coins;
    }

}
