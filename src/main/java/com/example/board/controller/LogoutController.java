package com.example.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        session.invalidate();
        PrintWriter out = resp.getWriter();
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
                }
                if (cookie.getName().equals("auto_login") || cookie.getName().equals("password")) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    resp.addCookie(cookie);
                }

            }
        }
//        로그아웃하면->기억하기==1 => 아이디남김 / 기억하기==null=>아이디지움

        if (rememberIdCookie==null && userIdCookie!=null) {
            userIdCookie.setMaxAge(0);
            userIdCookie.setPath("/");
            resp.addCookie(userIdCookie);
        }



        out.println("<script>alert('로그아웃 되었습니다.'); location.href='./';</script>");

    }
}
