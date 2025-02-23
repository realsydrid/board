package com.example.board.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/login.jsp")
public class RememberIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies = req.getCookies();
        Cookie rememberIdCookie = null;
        Cookie userIdCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "remember_id":
                        rememberIdCookie = cookie;
                        break;
                    case "user_id":
                        userIdCookie = cookie;
                        break;
                    default:
                        break;
                }
            }
        }
        if (rememberIdCookie ==null){
            chain.doFilter(request, response);
            return;
        }

        if (rememberIdCookie.getValue().equals("1")) {
            req.setAttribute("rememberedId", userIdCookie.getValue());
            chain.doFilter(request, response);
        }

    }
}
