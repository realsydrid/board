package com.example.board.dao;

import com.example.board.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/signUp.do")
public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_name=req.getParameter("user_name");
        String password=req.getParameter("password");
        String user_id=req.getParameter("user_id");
        String phone_no=req.getParameter("phone_no");
        PrintWriter out=resp.getWriter();
        int insert=0;
        try{
            Connection conn=DBConnection.getConnection();
            UserDto userDto=new UserDto();
            userDto.setUser_name(user_name);
            userDto.setPassword(password);
            userDto.setUser_id(user_id);
            userDto.setPhone_no(phone_no);
            UserDao userDao=new UserDaoImp(conn);
            insert=userDao.insert(userDto);


        }catch (Exception e){
            e.printStackTrace();
        }
        if(insert>0){
            out.println("<script>alert('가입성공');</script>");
            resp.sendRedirect(req.getContextPath()+"/login.do");
        }else {
            out.println("<script>alert('가입실패')</script>");
            resp.sendRedirect(req.getContextPath()+"/signUp.jsp");
        }
    }
}
