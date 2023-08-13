package by.pvt.core.multi.controller;

import by.pvt.api.dto.UserRequest;
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
            case "Register.html":
                doRegister(req);
                break;
            case "Login.html":
                break;
            }


        }

    private void doRegister(HttpServletRequest req) throws ServletException, IOException
        {
            UserRequest userRequest = new UserRequest(
                    req.getParameter("LoginLabel"),
                    req.getParameter("nameLabel"),
                    req.getParameter("surnameLabel"),
                    req.getParameter("PassLabel"),
                    req.getParameter("emaillable"),
                    req.getParameter("phonelabel"));


            Service service = new Service();
            service.register(userRequest);
        }

        private void doLogin(HttpServletRequest req, HttpServletResponse resp){

        }
    }



