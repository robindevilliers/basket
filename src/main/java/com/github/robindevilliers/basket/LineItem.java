package com.github.robindevilliers.basket;

public class LineItem {

    private final int quantity;

    private final ItemType name;

    private final int price;

    public LineItem(int quantity, ItemType name, int price) {
        if (name == null){
            throw new IllegalArgumentException("Invalid item type supplied for line item.");
        }
        if (quantity <= 0){
            throw new IllegalArgumentException("Invalid quantity supplied for line item.");
        }
        if (price <= 0){
            throw new IllegalArgumentException("Invalid price supplied for line item.");
        }
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemType getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
