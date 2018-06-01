package com.nobroker.vendingMachine.controller;

import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.bo.VendingMachine;
import com.nobroker.vendingMachine.controller.impl.UserActionControllerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SupplierAction {

    SupplierController supplier;

    @Before
    public void init(){
        supplier = new UserActionControllerImpl();
    }

    @Test
    public void testAddCoin()
    {
        supplier.addProduct("A4","Sprit", 10,2);
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Assert.assertEquals(vendingMachine.getProducts().get("A4").getQuantity(),7);
    }

}
