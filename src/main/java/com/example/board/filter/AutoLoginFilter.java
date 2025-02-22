package com.example.board.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.HttpCookie;

@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies =req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
//                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
        chain.doFilter(request, response);

    }
}
