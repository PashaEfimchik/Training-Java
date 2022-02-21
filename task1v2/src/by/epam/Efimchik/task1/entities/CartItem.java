package by.epam.Efimchik.task1.entities;

import java.util.Objects;

public class CartItem extends Product {
    private int id;
    private int quantityItem;
    private float totalPrice;
    private Product product;

    public CartItem(int id, int quantityItem, float totalPrice, Product product) {
        this.id = id;
        this.quantityItem = quantityItem;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantityItem=" + quantityItem +
                ", totalPrice=" + totalPrice +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id && quantityItem == cartItem.quantityItem && Float.compare(cartItem.totalPrice, totalPrice) == 0 && Objects.equals(product, cartItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, quantityItem, totalPrice, product);
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

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CartItem(int id, int quantity, String supplierName, String article, String name, float price, int id1, int quantityItem, float totalPrice, Product product) {
        super(id, quantity, supplierName, article, name, price);
        this.id = id1;
        this.quantityItem = quantityItem;
        this.totalPrice = totalPrice;
        this.product = product;
    }
}
