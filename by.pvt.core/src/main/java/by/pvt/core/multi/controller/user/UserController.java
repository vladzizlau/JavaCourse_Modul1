package by.pvt.core.multi.controller.user;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.config.ApplicationContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UserController extends HttpServlet {
    public void doRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // --- Проверка на логин для первоначальной регистрации админа. Если логин Admin, то роль у него будет Admin.
        String role = "";
        String login = req.getParameter("LoginLabel");
        if (login.equals("Admin"))
        {
            role = "Admin";
        }
        else
        {
            role = "Client";
        }
        try
        {
            UserRequest userRequest = new UserRequest(
                    ApplicationContext.getInstance().getUserService().getNewIndex(),
                    req.getParameter("LoginLabel"),
                    req.getParameter("nameLabel"),
                    req.getParameter("surnameLabel"),
                    req.getParameter("PassLabel"),
                    req.getParameter("emaillable"),
                    Long.parseLong(req.getParameter("phonelabel")),
                    role);


            if (userRequest.getLogin() != null && userRequest.getFirstName() != null && userRequest.getSurName() != null && userRequest.getPassword() != null && userRequest.getEmail() != null)
            {
                ApplicationContext.getInstance().getUserService().register(userRequest);
                //Session create
                HttpSession httpSession = ((HttpServletRequest) req).getSession(false);
                UserResponse userResponse = (UserResponse) httpSession.getAttribute("userAuth");

                if(userResponse.getRole().equals("Admin"))
                {
                    req.getRequestDispatcher("/admin.jsp").forward(req, resp);
                    httpSession.setAttribute("userAuth", userResponse);
                }
                else if (userResponse.getRole().equals("Client"))
                {
                    req.getRequestDispatcher("/client.jsp").forward(req, resp);
                    httpSession.setAttribute("userAuth", userResponse);
                }
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

    public void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String login = req.getParameter("LoginLabel");
        String pass = req.getParameter("PassLabel");
        try
        {
            UserResponse userResponse = ApplicationContext.getInstance().getUserService().auth(login, pass);
            String role = userResponse.getRole();
            if(role.equals("Admin"))
            {
                req.setAttribute("login", userResponse.getLogin());
                req.setAttribute("id", userResponse.getId());
                req.setAttribute("email", userResponse.getEmail());
                req.setAttribute("fname", userResponse.getFirstName());
                req.setAttribute("sname", userResponse.getSurName());
                req.setAttribute("phone", userResponse.getPhone());
                req.setAttribute("role", userResponse.getRole());
                req.getRequestDispatcher("/admin.jsp").forward(req, resp);
            }
            else {

                req.setAttribute("login", userResponse.getLogin());
                req.setAttribute("id", userResponse.getId());
                req.setAttribute("email", userResponse.getEmail());
                req.setAttribute("fname", userResponse.getFirstName());
                req.setAttribute("sname", userResponse.getSurName());
                req.setAttribute("phone", userResponse.getPhone());
                req.setAttribute("role", userResponse.getRole());
                req.getRequestDispatcher("/client.jsp").forward(req, resp);
            }

            //Session create
            var session = req.getSession(false);
            System.out.println(session.getId());
            session.setAttribute("userAuth", userResponse);


        } catch (Throwable e)
        {
            req.getRequestDispatcher("/errors/login.jsp").forward(req, resp);
        }

    }

}
