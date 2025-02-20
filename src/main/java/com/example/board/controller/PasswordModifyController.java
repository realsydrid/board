package com.example.board.controller;

import com.example.board.dao.PasswordChangeLogDaoImp;
import com.example.board.dto.PasswordChangeLogDto;
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

@WebServlet("/passwordModify.do")
public class PasswordModifyController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
        String newPassword=req.getParameter("newPassword");
        UserDto userDto= null;

        boolean modifyPassword=false;
        HttpSession session=req.getSession();
        Object user_id= session.getAttribute("user_id");
        int change_log=0;
        try{
            UserServiceImp userServiceImp=new UserServiceImp();
            userDto=userServiceImp.findUserById(user_id.toString());
            modifyPassword=userServiceImp.modifyPassword(userDto,newPassword);
            PasswordChangeLogDto passwordChangeLogDto=new PasswordChangeLogDto();
            passwordChangeLogDto.setUser_id(userDto.getUser_id());

            passwordChangeLogDto.setChanged_password(newPassword);
            System.out.println(passwordChangeLogDto.toString());
            PasswordChangeLogDaoImp passwordChangeLogDaoImp=new PasswordChangeLogDaoImp();


            //변경시 로그에 추가해야함




            if(modifyPassword){
                change_log=passwordChangeLogDaoImp.insert(passwordChangeLogDto);
                System.out.println(change_log);
                out.println("<script>alert('비밀번호 변경완료!');" +
                        "</script>");

            }
            else{
                out.println("<script>alert('비밀번호 실패!!!!!');</script>");
                resp.sendRedirect("/passwordModify.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
