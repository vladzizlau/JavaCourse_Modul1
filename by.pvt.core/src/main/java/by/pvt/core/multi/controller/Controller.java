package by.pvt.core.multi.controller;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.domain.User;
import by.pvt.core.multi.service.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

public class Controller extends HttpServlet
    {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Hello!");
        printWriter.close();


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
            }


        }

    private void doRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            try {
            UserRequest userRequest = new UserRequest(
                    req.getParameter("LoginLabel"),
                    req.getParameter("nameLabel"),
                    req.getParameter("surnameLabel"),
                    req.getParameter("PassLabel"),
                    req.getParameter("emaillable"),
                    req.getParameter("phonelabel"));


    if (userRequest.getLogin() != "" && userRequest.getFirstName() != "" && userRequest.getSurName() != "" && userRequest.getPassword() != "" && userRequest.getEmail() != "") {
        Service service = new Service();
        service.register(userRequest);
    } else {
        req.getRequestDispatcher("/errors/register.jsp").forward(req, resp);
    }
        }
            catch (NumberFormatException e){
        System.out.println("Ошибка номера телефона");
        req.getRequestDispatcher("/errors/register.jsp").forward(req, resp);




        }}

        private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String login = req.getParameter("LoginLabel");
            String pass = req.getParameter("PassLabel");

            Service service = new Service();
            try {
                UserResponse userResponse = service.auth(login, pass);
                req.setAttribute("login", userResponse.getLogin());
                req.setAttribute("id", userResponse.getId());
                req.setAttribute("email", userResponse.getEmail());
                req.setAttribute("fname", userResponse.getFirstName());
                req.setAttribute("sname", userResponse.getSurName());
                req.setAttribute("phone", userResponse.getPhone());
                req.setAttribute("role", userResponse.getRole());
                req.getRequestDispatcher("/cabinet.jsp").forward(req, resp);

            }
            catch (NullPointerException e)
            {
                req.getRequestDispatcher("/errors/login.jsp").forward(req, resp);


                //req.getRequestDispatcher("/login.jsp").forward(req, resp);

            }

        }
    }



