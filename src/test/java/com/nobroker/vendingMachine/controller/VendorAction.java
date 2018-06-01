package com.nobroker.vendingMachine.controller;

import com.nobroker.vendingMachine.bo.Coin;
import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.bo.VendingMachine;
import com.nobroker.vendingMachine.controller.impl.UserActionControllerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

//@RunWith(MockitoJUnitRunner.class)
public class VendorAction {

    VendorController vendor;


    @Before
    public void init(){
        vendor = new UserActionControllerImpl();
    }

    @Test
    public void testAddCoin()
    {
        vendor.addCoin(5);
        vendor.addCoin(20);
        vendor.addCoin(25);
        vendor.addCoin(10);
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Assert.assertEquals(vendingMachine.getTotalDeposit() , 60l);
    }

    @Test
    public void testGetProduct()
    {
        Product product = vendor.getProduct("A1");
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Assert.assertEquals(vendingMachine.getTotalDeposit() , 35l);
        Assert.assertEquals(product.getName() , "CocaCola");

        product = vendor.getProduct("A1");
        Assert.assertEquals(vendingMachine.getTotalDeposit() , 10l);
        Assert.assertEquals(product.getName() , "CocaCola");
    }

    @Test
    public void testReturnMoney()
    {
        Map<Coin, Integer> change = vendor.returnMoney();
        Assert.assertEquals(change.get(Coin.getInstance(25)), (Integer)0);
        Assert.assertEquals(change.get(Coin.getInstance(20)), (Integer)0);
        Assert.assertEquals(change.get(Coin.getInstance(10)), (Integer)1);
        Assert.assertEquals(change.get(Coin.getInstance(5)), (Integer)0);
        Assert.assertEquals(change.get(Coin.getInstance(1)), (Integer)0);
    }
}
