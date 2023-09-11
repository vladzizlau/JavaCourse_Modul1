package by.pvt.core.multi.controller;

import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;


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
            case "deleteUser":
                ApplicationContext.getInstance().getAdminController().deleteUser(req, resp);
                resp.sendRedirect("./admin/allusers.jsp");
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



