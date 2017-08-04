package com.github.robindevilliers.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<LineItem> lineItems = new ArrayList<>();

    public void addLineItem(LineItem lineItem) {
        if (lineItem == null) {
            throw new IllegalArgumentException("Invalid line item, null not allowed.");
        }
        lineItems.add(lineItem);
    }

    public LineItem getLineItem(int index) {
        return lineItems.get(index);
    }

    public int total() {
        return lineItems.stream()
                .map(lineItem -> lineItem.getPrice() * lineItem.getQuantity())
                .mapToInt(Integer::intValue)
                .sum();
    }
}
