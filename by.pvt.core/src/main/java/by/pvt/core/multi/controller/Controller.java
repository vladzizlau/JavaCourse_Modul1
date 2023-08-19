package by.pvt.core.multi.controller;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.repository.ProductRepository;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.service.ProductService;
import by.pvt.core.multi.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller extends HttpServlet
    {
        ApplicationContext applicationContext;
        ProductService productService;
    ProductRepository productRepository;
    UserRepository userRepository;
    UserService userService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
        String getLink = req.getParameter("action");
        switch (getLink)
            {
            case "add":
                doAdd(req, resp);
                resp.sendRedirect("./admin/addprod.jsp");
                break;
            case "edit":
                doEdit(req, resp);
                resp.sendRedirect("./admin/editprod.jsp");
                break;
            case "delete":
                doDel(req, resp);
                resp.sendRedirect("./admin/deleteprod.jsp");
                break;
            }
        }

    private void doAdd(HttpServletRequest req, HttpServletResponse resp)
        {
            applicationContext = new ApplicationContext();

        try
            {
            Product prod = new Product(Long.parseLong(req.getParameter("id")), req.getParameter("M_Type"), req.getParameter("M_Name"), Integer.parseInt(req.getParameter("M_Code")), Double.parseDouble(req.getParameter("M_Price")));
            List<Product> listProduct = new ArrayList<>();
            listProduct.add(prod);
            applicationContext.getProductService().addProduct(listProduct);
            } catch (NullPointerException e)
            {
            System.out.println("Controller.doAdd: " + e.getMessage());
            }
        }

    private void doEdit(HttpServletRequest req, HttpServletResponse resp)
        {
        applicationContext = new ApplicationContext();
        Product prodnew = applicationContext.getProductService().searchProduct(Long.parseLong(req.getParameter("id")));
        String name = req.getParameter("M_Name");
        int code = Integer.parseInt(req.getParameter("M_Code"));
        String type = req.getParameter("M_Type");
        double price = Double.parseDouble(req.getParameter("M_Price"));
        String id = req.getParameter("id");
        applicationContext.getProductService().editProduct(prodnew, name, code, type, price);
        }

        private void doDel(HttpServletRequest req, HttpServletResponse resp)
        {
            productService = new ProductService();
            Product prodnew = productService.searchProduct(Long.parseLong(req.getParameter("id")));
            productService.deleteProduct(prodnew);
        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
        String getLink = req.getParameter("link");
        switch (getLink)
            {
            case "Register.jsp":
                doRegister(req, resp);
                break;
            case "Login.jsp":
                doLogin(req, resp);
                break;
            case "loadShop":
                loadShop(req, resp);
                break;
            }
        }



    private void doRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            UserRequest userRequest;
            applicationContext = new ApplicationContext();
        String role = "";
        String login = req.getParameter("LoginLabel");
        if (login.equalsIgnoreCase("Admin"))
            {
            role = "Admin";
            }
        else
            {
            role = "Client";
            }
        try
            {
            userRequest = new UserRequest(
                    applicationContext.getUserService().getNewIndex(),
                    req.getParameter("LoginLabel"),
                    req.getParameter("nameLabel"),
                    req.getParameter("surnameLabel"),
                    req.getParameter("PassLabel"),
                    req.getParameter("emaillable"),
                    Long.parseLong(req.getParameter("phonelabel")),
                    role);


            if (userRequest.getLogin() != "" && userRequest.getFirstName() != "" && userRequest.getSurName() != "" && userRequest.getPassword() != "" && userRequest.getEmail() != "")
                {
                applicationContext.getUserService().register(userRequest);
                }
            else
                {
                req.getRequestDispatcher("/errors/register.jsp").forward(req, resp);
                }
            } catch (Throwable e)
            {
            System.out.println("Controller.doRegister(): [" + e.getClass() + "] " + e.getMessage());
            req.getRequestDispatcher("/errors/register.jsp").forward(req, resp);
            }
        }

    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
applicationContext = new ApplicationContext();
        String login = req.getParameter("LoginLabel");
        String pass = req.getParameter("PassLabel");
        try
            {
            UserResponse userResponse = applicationContext.getUserService().auth(login, pass);
            req.setAttribute("login", userResponse.getLogin());
            req.setAttribute("id", userResponse.getId());
            req.setAttribute("email", userResponse.getEmail());
            req.setAttribute("fname", userResponse.getFirstName());
            req.setAttribute("sname", userResponse.getSurName());
            req.setAttribute("phone", userResponse.getPhone());
            req.setAttribute("role", userResponse.getRole());
            req.getRequestDispatcher("/cabinet.jsp").forward(req, resp);

            } catch (Throwable e)
            {
            req.getRequestDispatcher("/errors/login.jsp").forward(req, resp);
            }

        }

    private void loadShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            applicationContext = new ApplicationContext();
        List<Product> product = applicationContext.getProductService().loadProds();
        for (int i = 0; i < 5; i++)
            {
            for (Product prod : applicationContext.getProductRepository().getAllProduct())
                {
                product.add(prod);
                }
            }
        req.setAttribute("products", product);
        req.setAttribute("list", product);

        getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
        }


    }



