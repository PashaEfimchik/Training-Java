package com.company.entities;

import java.util.Objects;

public class CartItem extends Product{
    private int id;
    private int quantityItem;

    @Override
    public String   toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantityItem=" + quantityItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id && quantityItem == cartItem.quantityItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, quantityItem);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public CartItem(int id, int quantityItem) {
        this.id = id;
        this.quantityItem = quantityItem;
    }

    public CartItem(int idProduct, int quantity, String supplierName, String article, String name, float price, int id, int quantityItem) {
        super(idProduct, quantity, supplierName, article, name, price);
        this.id = id;
        this.quantityItem = quantityItem;
    }
}
