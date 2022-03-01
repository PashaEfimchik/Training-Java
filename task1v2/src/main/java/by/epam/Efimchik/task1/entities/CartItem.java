package by.epam.Efimchik.task1.entities;

import java.util.Objects;

public class CartItem {
    private int id;
    private int quantityItem;
    private float totalPrice;
    private Product product;
    private User user;

    public CartItem() { }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantityItem=" + quantityItem +
                ", totalPrice=" + totalPrice +
                ", product=" + product +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id && quantityItem == cartItem.quantityItem && Float.compare(cartItem.totalPrice, totalPrice) == 0 && Objects.equals(product, cartItem.product) && Objects.equals(user, cartItem.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantityItem, totalPrice, product, user);
    }

    public int getId() {
        return id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CartItem(int id, int quantityItem, float totalPrice, Product product, User user) {
        this.id = id;
        this.quantityItem = quantityItem;
        this.totalPrice = totalPrice;
        this.product = product;
        this.user = user;
    }
}