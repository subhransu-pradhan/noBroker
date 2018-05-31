package com.nobroker.vendingMachine.bo;

import java.util.*;

public class Coin {
    private int value;
    private static final List<Integer> values = Arrays.asList(1,5,10,25);
    private static Map<Integer, Coin> coins = new HashMap<>(5);

    private Coin(int value) {
        setValue(value);
    }

    public static Coin getInstance(int value){
        Coin coin = coins.get(value);
        if(coin == null){
            synchronized (Coin.class){
                if(coins.get(value) == null) {
                    coin = new Coin(value);
                    coins.put(value, coin);
                }
            }
        }
        return coin;
    }

    private void setValue(int value) {
        if(values.contains(value))
            this.value = value;
        else
            throw new RuntimeException("Wrong coin");
    }

    public int getValue() {
        return value;
    }

    @Override
    public Object clone(){
        throw new RuntimeException("Clone Not allowed");
    }

    protected Object readResolve() {
        throw new RuntimeException("Deserialization Not Allowed");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return value == coin.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
