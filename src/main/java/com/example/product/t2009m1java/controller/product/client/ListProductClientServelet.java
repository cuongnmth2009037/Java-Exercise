package com.example.product.t2009m1java.controller.product.client;

import com.example.product.t2009m1java.model.MySqlProductModel;
import com.example.product.t2009m1java.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListProductClientServelet extends HttpServlet {
    private ProductModel productModel;

    public ListProductClientServelet() {this.productModel = new MySqlProductModel();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", productModel.findAll());
        req.getRequestDispatcher("/client/products/list.jsp").forward(req,resp);
    }
}
