package com.example.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setBannerCookie.do")
public class SetBannerCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String setBannerCookie=req.getParameter("setBannerCookie");
        resp.setContentType("text/html;charset=utf-8");
        out.println("<h1>하이</h1>");
        if(setBannerCookie!=null && setBannerCookie.equals("1")){
            Cookie bannerCookie=new Cookie("bannerCookie",setBannerCookie);
            bannerCookie.setPath("/");
            bannerCookie.setMaxAge(60*60*24);
            resp.addCookie(bannerCookie);
        }
        out.println("<script> window.close();</script>");


    }
}
