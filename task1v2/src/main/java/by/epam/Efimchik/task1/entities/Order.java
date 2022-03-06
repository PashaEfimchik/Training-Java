package by.epam.Efimchik.task1.entities;

import java.util.Objects;

public class Order{
    private int orderId;
    private Product product;
    private User user;
    private float orderTotal;
    private int orderQuantity;
    private OrderStatus orderStatus;

    public static int orderObjectCounter = 0;
    {
        orderObjectCounter++;
    }

    public Order() {}

    public Order(int orderId, Product product, User user, float orderTotal, int orderQuantity, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.product = product;
        this.user = user;
        this.orderTotal = orderTotal;
        this.orderQuantity = orderQuantity;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Float.compare(order.orderTotal, orderTotal) == 0 && orderQuantity == order.orderQuantity && Objects.equals(product, order.product) && Objects.equals(user, order.user) && Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, product, user, orderTotal, orderQuantity, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", product=" + product +
                ", user=" + user +
                ", orderTotal=" + orderTotal +
                ", orderQuantity=" + orderQuantity +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
