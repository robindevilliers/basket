package com.github.robindevilliers.basket;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LineItemTest {

    @Test
    public void lineItemConstruction() {
        LineItem lineItem = new LineItem(12, ItemType.Bananas, 433);
        assertThat(lineItem.getName(), is(ItemType.Bananas));
        assertThat(lineItem.getQuantity(), is(12));
        assertThat(lineItem.getPrice(), is(433));
    }

    @Test
    public void nullNameShouldError() {
        try {
            new LineItem(12, null, 433);
            fail("Expected error due to invalid item type");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Invalid item type supplied for line item."));
        } catch (RuntimeException e) {
            fail("Invalid failure exception.");
        }
    }

    @Test
    public void zeroQuantityShouldError() {
        try {
            new LineItem(0, ItemType.Bananas, 433);
            fail("expected error due to invalid quantity");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Invalid quantity supplied for line item."));
        } catch (RuntimeException e) {
            fail("Invalid failure exception.");
        }
    }

    @Test
    public void negativeQuantityShouldError() {
        try {
            new LineItem(-1, ItemType.Bananas, 433);
            fail("expected error due to invalid quantity");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Invalid quantity supplied for line item."));
        } catch (RuntimeException e) {
            fail("Invalid failure exception.");
        }
    }

    @Test
    public void zeroPriceShouldError() {
        try {
            new LineItem(10, ItemType.Bananas, 0);
            fail("expected error due to invalid price");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Invalid price supplied for line item."));
        } catch (RuntimeException e) {
            fail("Invalid failure exception.");
        }
    }

    @Test
    public void negativePriceShouldError() {
        try {
            new LineItem(10, ItemType.Bananas, -1);
            fail("expected error due to invalid price");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Invalid price supplied for line item."));
        } catch (RuntimeException e) {
            fail("Invalid failure exception.");
        }
    }
}