package com.example.board.dao;

import com.example.board.dto.LoginLogDto;
import com.example.board.dto.UserDto;
import com.example.board.service.UserService;
import com.example.board.service.UserServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
        System.out.println("1");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("2");
        String user_id = req.getParameter("user_id");
        String password = req.getParameter("password");
        String user_name;
        String ip_address;
        String browser;
        int user_no;
        boolean login = false;
        UserDto userDto;
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");

        try{
            System.out.println("3");
            UserService userServiceImp = new UserServiceImp();
            LoginLogDaoImp loginLogDaoImp = new LoginLogDaoImp();
            LoginLogDto loginLogDto = new LoginLogDto();
            userDto= userServiceImp.findUserById(user_id);
            login = userDto!=null && userServiceImp.login(user_id, password);

            if (login) {
                System.out.println("4");

                user_name = userDto.getUser_name();
                user_no = userDto.getUser_no();
                ip_address=req.getRemoteAddr();

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
                HttpSession session = req.getSession();
                session.setAttribute("user_id", user_id);
                session.setAttribute("password", password);
                session.setAttribute("user_name", user_name);
                session.setAttribute("login", login);
                resp.sendRedirect(req.getContextPath());
                System.out.println("5");
            }
            else{
                System.out.println("6");

                out.println("<script>");
                out.println("alert('로그인 실패!!!!!!!');");
                out.println("location.href='" + req.getContextPath() + "/login.jsp';");
                out.println("</script>");


            }
            System.out.println("7");







        }catch (Exception e){
            e.printStackTrace();
            System.out.println("8");
        }
    }
}
