package com.example.board.dao;

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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("user_id");
        String password = req.getParameter("password");
        String user_name;
        boolean login = false;
        UserDto userDto;
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");

        try{
            UserService userServiceImp = new UserServiceImp();
            login = userServiceImp.login(user_id, password);
            if (login) {
                userDto = userServiceImp.findUserById(user_id);
                user_name = userDto.getUser_name();
                HttpSession session = req.getSession();
                session.setAttribute("user_id", user_id);
                session.setAttribute("password", password);
                session.setAttribute("user_name", user_name);
                session.setAttribute("login", login);
                resp.sendRedirect(req.getContextPath());
            }
            else{

                out.println("<script>");
                out.println("alert('로그인 실패!!!!!!!');");
                out.println("location.href='" + req.getContextPath() + "/login.jsp';");
                out.println("</script>");


            }






        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
