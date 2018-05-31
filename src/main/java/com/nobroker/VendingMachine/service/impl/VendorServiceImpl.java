package com.nobroker.VendingMachine.service.impl;

import com.nobroker.VendingMachine.bo.Product;
import com.nobroker.VendingMachine.dao.WalletDao;
import com.nobroker.VendingMachine.dao.impl.WalletDaoImpl;
import com.nobroker.VendingMachine.bo.Coin;
import com.nobroker.VendingMachine.dao.ProductsDaoCustomer;
import com.nobroker.VendingMachine.dao.impl.ProductDaoImpl;
import com.nobroker.VendingMachine.service.VendorService;

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