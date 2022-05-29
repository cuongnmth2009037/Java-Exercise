package com.example.product.t2009m1java.controller;

import com.example.product.t2009m1java.entity.Product;
import com.example.product.t2009m1java.model.MySqlProductModel;
import com.example.product.t2009m1java.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productModel.findAll();
        req.setAttribute("productlist", productList);
        req.getRequestDispatcher("/product/list.jsp").forward(req,resp);
    }
}
