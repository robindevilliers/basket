package com.github.robindevilliers.basket;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BasketTest {

    @Test
    public void addLineItemToBasket() {

        LineItem lineItem = new LineItem(10, ItemType.Peaches, 80);

        Basket basket = new Basket();
        basket.addLineItem(lineItem);

        LineItem subject = basket.getLineItem(0);
        assertThat(subject.getQuantity(), is(10));
        assertThat(subject.getName(), is(ItemType.Peaches));
        assertThat(subject.getPrice(), is(80));
    }

    @Test
    public void addTwoLineItemsToBasket() {

        LineItem peachesLineItem = new LineItem(2, ItemType.Peaches, 33);
        LineItem applesLineItem = new LineItem(3, ItemType.Apples, 44);

        Basket basket = new Basket();
        basket.addLineItem(peachesLineItem);
        basket.addLineItem(applesLineItem);

        LineItem subjectPeaches = basket.getLineItem(0);
        assertThat(subjectPeaches.getQuantity(), is(2));
        assertThat(subjectPeaches.getName(), is(ItemType.Peaches));
        assertThat(subjectPeaches.getPrice(), is(33));

        LineItem subjectApples = basket.getLineItem(1);
        assertThat(subjectApples.getQuantity(), is(3));
        assertThat(subjectApples.getName(), is(ItemType.Apples));
        assertThat(subjectApples.getPrice(), is(44));
    }

    @Test
    public void addingNullToBasketShouldError() {
        try {
            new Basket().addLineItem(null);
            fail("Expected error due to invalid line item.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Invalid line item, null not allowed."));
        } catch (RuntimeException e) {
            fail("Invalid failure exception.");
        }
    }

    @Test
    public void totalBasketWithOneItem() {
        Basket basket = new Basket();
        basket.addLineItem(new LineItem(10, ItemType.Peaches, 80));
        assertThat(basket.total(), is(800));
    }

    @Test
    public void totalBasketWithMultipleItems() {
        Basket basket = new Basket();
        basket.addLineItem(new LineItem(4, ItemType.Peaches, 120));
        basket.addLineItem(new LineItem(2, ItemType.Bananas, 100));
        assertThat(basket.total(), is(680));
    }

    @Test
    public void aBasketShouldContainMultipleOfTheSameType(){
        Basket basket = new Basket();
        basket.addLineItem(new LineItem(10, ItemType.Peaches, 80));
        basket.addLineItem(new LineItem(2, ItemType.Peaches, 85));
        assertThat(basket.total(), is(970));
    }
}