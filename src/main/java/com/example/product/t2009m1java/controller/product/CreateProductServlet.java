package com.example.product.t2009m1java.controller.product;

import com.example.product.t2009m1java.entity.Product;
import com.example.product.t2009m1java.model.MySqlProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {
    private MySqlProductModel mySqlProductModel;

    @Override
    public void init() throws ServletException {
        mySqlProductModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/product/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Double price = 0.0;
        if(req.getParameter("price") != null && req.getParameter("price") != "") {
            price = Double.parseDouble(req.getParameter("price"));
        }
        String thumbnail = req.getParameter("thumbnail");
        String manufactureEmail = req.getParameter("manufactureEmail");
        String manufacturePhone = req.getParameter("manufacturePhone");
        Product product = new Product(name, description,detail, price, thumbnail, manufactureEmail, manufacturePhone);
        if(product.isValid()) {
            mySqlProductModel.save(product);
            resp.sendRedirect("/product/list");
        }else {
            req.setAttribute("errors", product.getErrors());
            req.setAttribute("product", product);
            req.getRequestDispatcher("/product/create.jsp").forward(req,resp);
        }
    }
}
