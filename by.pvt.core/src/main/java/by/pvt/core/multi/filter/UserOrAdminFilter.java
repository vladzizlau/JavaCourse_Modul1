package by.pvt.core.multi.filter;

import by.pvt.api.dto.UserResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UserOrAdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession(false);
        //String page = ((HttpServletRequest) servletRequest).getRequestURI();
        UserResponse userResponse = (UserResponse) httpSession.getAttribute("userAuth");
        if (userResponse.getRole().equals("Admin")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (userResponse.getRole().equals("Client")) {
            servletRequest.getRequestDispatcher("/bad2.jsp").forward(servletRequest, servletResponse);
        }


    }
}
