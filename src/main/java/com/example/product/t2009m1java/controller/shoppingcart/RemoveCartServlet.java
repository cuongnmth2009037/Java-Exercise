package com.example.product.t2009m1java.controller.shoppingcart;

import com.example.product.t2009m1java.entity.ShoppingCart;
import com.example.product.t2009m1java.model.MySqlProductModel;
import com.example.product.t2009m1java.model.ProductModel;
import com.example.product.t2009m1java.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCartServlet extends HttpServlet {
    private ProductModel productModel;

    public RemoveCartServlet() {this.productModel = new MySqlProductModel();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //lấy tham số khi người dùng tiến hành click add to cart.
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            //check xem shopping cart có trong session chưa, có rồi thì lấy ra
            //chưa có thì tạo mới
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
            //xóa sản phẩm khỏi shopping cart
            shoppingCart.remove(productId);
            //lươ shopping cart vào session
            shoppingCartHelper.saveCart(shoppingCart);
            resp.sendRedirect("/shopping-cart/get");
        }catch (Exception e){
            resp.getWriter().println(e.getMessage());
        }
    }
}
