package com.example.board.dao;

import com.example.board.dto.PasswordChangeLogDto;
import com.example.board.dto.UserDto;
import com.example.board.service.UserServiceImp;
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
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        boolean signUp;
        PasswordChangeLogDto passwordChangeLogDto;
        PasswordChangeLogDaoImp passwordChangeLogDaoImp;


        try{
            passwordChangeLogDaoImp=new PasswordChangeLogDaoImp();
            passwordChangeLogDto=new PasswordChangeLogDto();

            UserServiceImp userServiceImp=new UserServiceImp();
            UserDto userDto=new UserDto();
            userDto.setUser_name(user_name);
            userDto.setPassword(password);
            userDto.setUser_id(user_id);
            userDto.setPhone_no(phone_no);
            passwordChangeLogDto.setChanged_password(password);
            passwordChangeLogDto.setUser_id(user_id);

            boolean isUserIdExists = userServiceImp.findUserById(user_id) != null;
            
            if (isUserIdExists) {
                out.println("<script>");
                out.println("alert('중복된 아이디가 존재합니다.');");
                out.println("location.href='" + req.getContextPath() + "/signUp.jsp';");
                out.println("</script>");
                return;  
            }
            passwordChangeLogDaoImp.insert(passwordChangeLogDto);
            signUp=userServiceImp.signUp(userDto);

            if (signUp) {
                out.println("<script>");
                out.println("alert('가입성공');");
                out.println("location.href='" + req.getContextPath() + "/login.jsp';");
                out.println("</script>");
            } else {
                out.println("<script>");
                out.println("alert('가입실패');");
                out.println("location.href='" + req.getContextPath() + "/signUp.jsp';");
                out.println("</script>");
            }
            
        }catch (Exception e){
            e.printStackTrace();
            out.println("<script>");
            out.println("alert('오류가 발생했습니다.');");
            out.println("location.href='" + req.getContextPath() + "/signUp.jsp';");
            out.println("</script>");
        }
    }
}
