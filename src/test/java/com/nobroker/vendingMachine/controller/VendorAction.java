package com.nobroker.vendingMachine.controller;

import com.nobroker.vendingMachine.bo.Coin;
import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.controller.impl.UserActionControllerImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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

    }


}
