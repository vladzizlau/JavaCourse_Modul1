package by.pvt.core.multi.controller;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.User;
import by.pvt.core.multi.repository.ProductRepository;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.service.ProductService;
import by.pvt.core.multi.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller extends HttpServlet
    {
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {

        String getLink = req.getParameter("action");
        switch (getLink)
            {
            case "add":
                ApplicationContext.getInstance().getAdminController().doAdd(req, resp);
                resp.sendRedirect("./admin/addprod.jsp");
                break;
            case "edit":
                ApplicationContext.getInstance().getAdminController().doEditProd(req, resp);
                resp.sendRedirect("./admin/editprod.jsp");
                break;
            case "delete":
                ApplicationContext.getInstance().getAdminController().doDel(req, resp);
                resp.sendRedirect("./admin/deleteprod.jsp");
                break;
                case "cart":
                    ApplicationContext.getInstance().getCartController().toCart(req, resp);
                   resp.sendRedirect("./index.jsp");
                    break;
            }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
        String getLink = req.getParameter("link");
        switch (getLink)
            {
            case "Register.jsp":
                ApplicationContext.getInstance().getUserController().doRegister(req, resp);
                break;
            case "Login.jsp":
                ApplicationContext.getInstance().getUserController().doLogin(req, resp);
                break;
            case "loadShop":
                loadShop(req, resp);
                break;
            case "cart":
                ApplicationContext.getInstance().getCartController().toCart(req, resp);
                resp.sendRedirect("./index.jsp");
                break;
                case "Payment":
                    ApplicationContext.getInstance().getCartController().doPayment(req, resp);
                    resp.sendRedirect("./client/payment.jsp");
                    break;
            }

        }


        //Метоод подгружает товары на главную страницу
    private void loadShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
        ArrayList<Product> product = new ArrayList<>();
            for (Product prod : ApplicationContext.getInstance().getProductRepository().getAllProduct())
                {
                product.add(prod);
                }
        req.setAttribute("products", product);
        req.setAttribute("list", product);
        getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
        }


    }



