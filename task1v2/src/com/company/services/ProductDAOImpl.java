package com.company.services;

import com.company.dao.ProductDAO;
import com.company.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAOImpl implements ProductDAO {
    List<Product> productList = new ArrayList<>();

    @Override
    public boolean addProduct(Product p){
        return productList.add(p);
    }

    @Override
    public Product productById (int id) {
        for(Product product : productList) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> selectAllProduct () {
        return productList;
    }

    @Override
    public List<Product> searchProduct (String par) {
        List<Product> searchProductList = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(par)){
                searchProductList.add(p);
            }
        }
        return searchProductList;
    }

    @Override
    public boolean removeProductById (int id) {
        Product p = productById(id);

        if (p != null) {
            return productList.remove(p);
        }
        return false;
    }

    @Override
    public void uploadProducts() {}
}
