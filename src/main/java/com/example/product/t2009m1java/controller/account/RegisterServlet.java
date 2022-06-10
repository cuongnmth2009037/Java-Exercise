package com.example.product.t2009m1java.controller.account;

import com.example.product.t2009m1java.entity.Account;
import com.example.product.t2009m1java.entity.entityEnum.ObjectStatus;
import com.example.product.t2009m1java.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private AccountService accountService;

    public RegisterServlet() {
        this.accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client/users/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        Account account = Account.AccountBuilder.anAccount()
                .username(username)
                .password(password)
                .confirmPassword(confirmPassword)
                .build();

        account = accountService.register(account);
        req.setAttribute("account", account);
        req.getRequestDispatcher("/client/users/register-success.jsp").forward(req,resp);
    }
}
