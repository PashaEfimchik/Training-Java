package by.epam.Efimchik.task1.entities;

import java.util.Objects;

public class Product {
    private int productId;
    private String article;
    private String name;
    private String supplierName;
    private float productPrice;

    public Product() {}

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", article='" + article + '\'' +
                ", name='" + name + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Float.compare(product.productPrice, productPrice) == 0 && Objects.equals(article, product.article) && Objects.equals(name, product.name) && Objects.equals(supplierName, product.supplierName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, article, name, supplierName, productPrice);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public Product(int productId, String article, String name, String supplierName, float productPrice) {
        this.productId = productId;
        this.article = article;
        this.name = name;
        this.supplierName = supplierName;
        this.productPrice = productPrice;
    }
}
