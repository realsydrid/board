package com.example.board.filter;

import com.example.board.controller.LoginController;
import com.example.board.dao.imp.LoginLogDaoImp;
import com.example.board.dto.LoginLogDto;
import com.example.board.dto.UserDto;
import com.example.board.service.UserService;
import com.example.board.service.UserServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies = req.getCookies();
        Cookie autoLoginCookie = null;
        Cookie userIdCookie = null;
        Cookie passwordCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "auto_login":
                        autoLoginCookie = cookie;
                        break;
                    case "user_id":
                        userIdCookie = cookie;
                        break;
                    case "password":
                        passwordCookie = cookie;
                        break;
                    default:
                        break;
                }

            }
        }


        HttpSession session = req.getSession();
        Object loginSession = session.getAttribute("login");
        if (loginSession != null) {
            chain.doFilter(request, response);
            return;
        }


        if (autoLoginCookie != null && autoLoginCookie.getValue().equals("1") && userIdCookie !=null) {

            String user_id = userIdCookie.getValue();
            String password = passwordCookie.getValue();
            String user_name;
            String ip_address;
            String browser;
            int user_no;
            boolean login = false;
            UserDto userDto;
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html;charset=utf-8");

            try {

                UserService userServiceImp = new UserServiceImp();
                LoginLogDaoImp loginLogDaoImp = new LoginLogDaoImp();
                LoginLogDto loginLogDto = new LoginLogDto();
                userDto = userServiceImp.findUserById(user_id);
                login = userDto != null && userServiceImp.login(user_id, password);

                if (login) {
                    user_name = userDto.getUser_name();
                    user_no = userDto.getUser_no();
                    ip_address = req.getRemoteAddr();

                    try {
                        String userAgent = req.getHeader("User-Agent");
                        if (userAgent != null) {
                            if (userAgent.contains("Chrome")) {
                                browser = "Chrome";
                            } else if (userAgent.contains("Firefox")) {
                                browser = "Firefox";
                            } else if (userAgent.contains("Safari")) {
                                browser = "Safari";
                            } else if (userAgent.contains("Edge")) {
                                browser = "Edge";
                            } else if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                                browser = "Internet Explorer";
                            } else {
                                browser = "Other";
                            }
                        } else {
                            browser = "Unknown";
                        }
                        loginLogDto.setBrowser(browser);
                    } catch (Exception e) {
                        browser = "Unknown";
                        loginLogDto.setBrowser(browser);
                    }
                    loginLogDto.setBrowser(browser);
                    loginLogDto.setUser_no(user_no);
                    loginLogDto.setIp_address(ip_address);
                    loginLogDaoImp.insert(loginLogDto);
                    session.setAttribute("user_id", user_id);
                    session.setAttribute("user_name", user_name);
                    session.setAttribute("login", login);
                    resp.sendRedirect(req.getContextPath());
                } else {
                    out.println("<script>");
                    out.println("alert('로그인 실패!!!!!!!');");
                    out.println("location.href='" + req.getContextPath() + "/login.jsp';");
                    out.println("</script>");
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        chain.doFilter(request, response);
    }


}

