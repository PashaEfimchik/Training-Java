package com.company.entities;

import java.util.Objects;

public class CartItem extends Product{
    private int idCart;
    private int quantityItem;
    private float totalPrice;

    @Override
    public String toString() {
        return "CartItem{" +
                "idCart=" + idCart +
                ", quantityItem=" + quantityItem +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CartItem cartItem = (CartItem) o;
        return idCart == cartItem.idCart && quantityItem == cartItem.quantityItem && Float.compare(cartItem.totalPrice, totalPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idCart, quantityItem, totalPrice);
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartItem(int idCart, int quantityItem, float totalPrice) {
        this.idCart = idCart;
        this.quantityItem = quantityItem;
        this.totalPrice = totalPrice;
    }

    public CartItem(int id, int quantity, String supplierName, String article, String name, float price, int idCart, int quantityItem, float totalPrice) {
        super(id, quantity, supplierName, article, name, price);
        this.idCart = idCart;
        this.quantityItem = quantityItem;
        this.totalPrice = totalPrice;
    }
}
