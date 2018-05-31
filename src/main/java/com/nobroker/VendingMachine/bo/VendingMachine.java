package com.nobroker.VendingMachine.bo;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private long totalDeposit;
    private Map<String, Product> products;
    private Map<Coin, Integer> coins = new HashMap<>();

    private static VendingMachine vendingMachine;

    private VendingMachine() {
        products = new HashMap<String, Product>();
        this.addProduct("A1", new Product("CocaCola", 25) );
        this.addProduct("A2", new Product("Pepsi", 15));
        this.addProduct("A3", new Product("7UP", 20));
        this.addProduct("A4", new Product("Sprit", 10));


        this.addCoins(Coin.getInstance(25), 50);
        this.addCoins(Coin.getInstance(20), 50);
        this.addCoins(Coin.getInstance(10), 50);
        this.addCoins(Coin.getInstance(5), 50);
        this.addCoins(Coin.getInstance(1), 50);
    }

    public long getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(long totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public void setCoins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public void addCoins(Coin coin) {
        this.addCoins(coin, 1);
    }

    public void addCoins(Coin coin, int quantity) {
        totalDeposit = totalDeposit + coin.getValue() * quantity;
        this.coins.put(coin, this.coins.get(coin) + quantity);
    }

    public void addProduct(String code, Product product){
        Product productToAdd = products.get(code);
        if(productToAdd == null)
            products.put(code, product);
        else
            productToAdd.setQuantity(product.getQuantity() + product.getQuantity());
        products.put(code, productToAdd);
    }

    public Product getProduct(String code){
        Product product = products.get(code);
        if(product.getQuantity() > 1)
        {
            product.setQuantity(product.getQuantity()-1);
        }
        return product;
    }

    public static VendingMachine getInstance(){
        if(vendingMachine == null){
            synchronized (VendingMachine.class){
                if(vendingMachine == null){
                    vendingMachine = new VendingMachine();
                }
            }
        }
        return vendingMachine;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    protected Object readResolve() {
        return getInstance();
    }
}
