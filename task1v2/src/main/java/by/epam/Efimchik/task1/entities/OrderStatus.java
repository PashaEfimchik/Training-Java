package by.epam.Efimchik.task1.entities;

import java.util.Objects;

public class OrderStatus {
    private int orderStatusId;
    private String orderStatusType;

    public OrderStatus() {}

    @Override
    public String toString() {
        return "OrderStatus{" +
                "orderStatusId=" + orderStatusId +
                ", orderStatusType='" + orderStatusType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus that = (OrderStatus) o;
        return orderStatusId == that.orderStatusId && Objects.equals(orderStatusType, that.orderStatusType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderStatusId, orderStatusType);
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderStatusType() {
        return orderStatusType;
    }

    public void setOrderStatusType(String orderStatusType) {
        this.orderStatusType = orderStatusType;
    }

    public OrderStatus(int orderStatusId, String orderStatusType) {
        this.orderStatusId = orderStatusId;
        this.orderStatusType = orderStatusType;
    }
}
