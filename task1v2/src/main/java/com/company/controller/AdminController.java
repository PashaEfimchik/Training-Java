package com.company.controller;

import com.company.dao.ProductDAOException;

public class AdminController extends ProductController{
    @Override
    public void productProcess() throws ProductDAOException {
        super.productProcess();
    }
}
