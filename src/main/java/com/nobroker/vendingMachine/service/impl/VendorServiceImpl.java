package com.nobroker.vendingMachine.service.impl;

import com.nobroker.vendingMachine.bo.Product;
import com.nobroker.vendingMachine.dao.WalletDao;
import com.nobroker.vendingMachine.dao.impl.WalletDaoImpl;
import com.nobroker.vendingMachine.bo.Coin;
import com.nobroker.vendingMachine.dao.ProductsDaoCustomer;
import com.nobroker.vendingMachine.dao.impl.ProductDaoImpl;
import com.nobroker.vendingMachine.service.VendorService;

import java.util.Map;

public class VendorServiceImpl implements VendorService {

    ProductsDaoCustomer productDao = new ProductDaoImpl();
    WalletDao walletDao = new WalletDaoImpl();

    public void addCoin(Coin coin) {
        walletDao.addCoin(coin);
    }

    public Product getProduct(String productId) {
        Product product = productDao.getProduct(productId);
        walletDao.spendMoney(product.getPrice());
        return product;
    }

    public Map<Coin, Integer> returnMoney(){
        return walletDao.returnChange();
    }

}