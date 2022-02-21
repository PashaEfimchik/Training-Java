package by.epam.Efimchik.task1.entities;

import java.util.Objects;

public class Order extends CartItem{
    private int id;
    private int number;
    private CartItem cartItem;
    private boolean status;

    public Order(int id, int quantityItem, float totalPrice, Product product, int id1, int number, CartItem cartItem, boolean status) {
        super(id, quantityItem, totalPrice, product);
        this.id = id1;
        this.number = number;
        this.cartItem = cartItem;
        this.status = status;
    }

    public Order(int id, int quantity, String supplierName, String article, String name, float price, int id1, int quantityItem, float totalPrice, Product product, int id2, int number, CartItem cartItem, boolean status) {
        super(id, quantity, supplierName, article, name, price, id1, quantityItem, totalPrice, product);
        this.id = id2;
        this.number = number;
        this.cartItem = cartItem;
        this.status = status;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return id == order.id && number == order.number && status == order.status && Objects.equals(cartItem, order.cartItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, number, cartItem, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number=" + number +
                ", cartItem=" + cartItem +
                ", status=" + status +
                '}';
    }
}
