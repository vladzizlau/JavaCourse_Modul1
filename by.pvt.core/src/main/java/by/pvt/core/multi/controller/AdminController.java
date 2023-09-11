package by.pvt.core.multi.controller;

import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class AdminController extends HttpServlet {
    public void doAdd(HttpServletRequest req, HttpServletResponse resp)
    {

        try
        {
            Product prod = new Product(Long.parseLong(req.getParameter("id")), req.getParameter("M_Type"), req.getParameter("M_Name"), Integer.parseInt(req.getParameter("M_Code")), Double.parseDouble(req.getParameter("M_Price")));
            ArrayList<Product> listProduct = new ArrayList<>();
            listProduct.add(prod);
            ApplicationContext.getInstance().getProductService().addProduct(listProduct);
        } catch (NullPointerException e)
        {
            System.out.println("Controller.doAdd: " + e.getMessage());
        }
    }

    public void doEditProd(HttpServletRequest req, HttpServletResponse resp)
    {

        Product prodnew = ApplicationContext.getInstance().getProductService().searchIDProduct(Long.parseLong(req.getParameter("id")));
        String name = req.getParameter("M_Name");
        int code = Integer.parseInt(req.getParameter("M_Code"));
        String type = req.getParameter("M_Type");
        double price = Double.parseDouble(req.getParameter("M_Price"));
        String id = req.getParameter("id");
        ApplicationContext.getInstance().getProductService().editProduct(prodnew, name, code, type, price);
    }


    public void doDel(HttpServletRequest req, HttpServletResponse resp)        {
        System.out.println(req.getParameter("id"));
        Product prodnew = ApplicationContext.getInstance().getProductService().searchIDProduct(Long.parseLong(req.getParameter("id")));
        ApplicationContext.getInstance().getProductService().deleteProduct(prodnew);
    }
public void deleteUser(HttpServletRequest req, HttpServletResponse resp)
    {
    System.out.println(req.getParameter("login"));
    User userNew = ApplicationContext.getInstance().getUserService().getUser(req.getParameter("login"));
    ApplicationContext.getInstance().getUserService().deleteUser(userNew);
    }
}
