package com.example.product.t2009m1java.controller;

import com.example.product.t2009m1java.entity.Product;
import com.example.product.t2009m1java.entity.entityEnum.ProductStatus;
import com.example.product.t2009m1java.model.MySqlProductModel;
import com.example.product.t2009m1java.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class DeleteProductServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        product.setStatus(ProductStatus.DELETED);
        product.setDeletedAt(LocalDateTime.now());
        if (productModel.update(id,product)){
            resp.sendRedirect("/product/list");
        }
    }
}
