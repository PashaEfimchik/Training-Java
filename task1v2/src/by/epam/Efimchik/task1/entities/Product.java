package by.epam.Efimchik.task1.entities;

import java.util.Objects;

public class Product {
    private int id;
    private int quantity;
    private String supplierName;
    private String article;
    private String name;
    private float price;

    public Product() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(supplierName, product.supplierName) && Objects.equals(article, product.article) && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierName, article, name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", supplierName='" + supplierName + '\'' +
                ", article='" + article + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(int id, int quantity, String supplierName, String article, String name, float price) {
        this.id = id;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.article = article;
        this.name = name;
        this.price = price;
    }
}
