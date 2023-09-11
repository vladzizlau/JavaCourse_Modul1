package by.pvt.core.multi.filter;

import by.pvt.api.dto.UserResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession(false);
        String page = ((HttpServletRequest) servletRequest).getRequestURI();
        try {
            UserResponse userResponse = (UserResponse) httpSession.getAttribute("userAuth");
            System.out.println(userResponse.getRole());
            System.out.println(page);
            if (httpSession == null && httpSession.getAttribute("userAuth") == null) {
                    servletRequest.getRequestDispatcher("/bad2.jsp").forward(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        catch (Exception e)
        {
            servletRequest.getRequestDispatcher("/error.jsp").forward(servletRequest, servletResponse);
        }

    }



}
