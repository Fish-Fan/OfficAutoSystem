package com.fanyank.filter;

import com.fanyank.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OASystemFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();
        if(path.startsWith("/user") || path.startsWith("/static")) {
            chain.doFilter(request,response);
        } else {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("current_user");
            if(user != null) {
                chain.doFilter(request,response);
            } else {
                res.sendRedirect("/user/login?s=0");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
