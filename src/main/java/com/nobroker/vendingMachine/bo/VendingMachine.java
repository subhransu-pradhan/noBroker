package com.nobroker.vendingMachine.bo;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private long totalDeposit;
    private Map<String, Product> products;
    private Map<Coin, Integer> coins = new HashMap<>();

    private static VendingMachine vendingMachine;

    private VendingMachine() {
        products = new HashMap<String, Product>();
        this.addProduct("A1", new Product("CocaCola", 25, 5) );
        this.addProduct("A2", new Product("Pepsi", 15, 5));
        this.addProduct("A3", new Product("7UP", 20, 5));
        this.addProduct("A4", new Product("Sprit", 10,5));

        this.coins.put(Coin.getInstance(25), 50);
        this.coins.put(Coin.getInstance(20), 50);
        this.coins.put(Coin.getInstance(10), 50);
        this.coins.put(Coin.getInstance(5), 50);
        this.coins.put(Coin.getInstance(1), 50);
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
        if(this.coins.get(coin) == null)
            this.coins.put(coin, quantity);
        else
            this.coins.put(coin, this.coins.get(coin) + quantity);
    }

    public void addProduct(String code, Product product){
        Product productToAdd = products.get(code);
        if(productToAdd == null)
            productToAdd = product;
        else
            productToAdd.setQuantity(product.getQuantity() + productToAdd.getQuantity());
        products.put(code, productToAdd);
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public Product getProduct(String code){
        Product product = products.get(code);
        if(product == null){
            throw new RuntimeException("Product not Found.");
        }
        if(product.getQuantity() > 1)
        {
            product.setQuantity(product.getQuantity()-1);
        }
        else
        {
            throw new RuntimeException("Product is not Available.");
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
