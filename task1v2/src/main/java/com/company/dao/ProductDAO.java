package com.company.dao;

import com.company.entities.Product;

import java.util.List;

public interface ProductDAO {
    boolean addProduct (Product p) throws ProductDAOException;

    boolean removeProductById (int id) throws ProductDAOException;

    void uploadProducts (List<Product> listProduct) throws ProductDAOException;

    Product productById (int id) throws ProductDAOException;

    List<Product> selectAllProduct (List<Product> listProduct) throws ProductDAOException;

    List<Product> searchProduct (String par) throws ProductDAOException;

}
