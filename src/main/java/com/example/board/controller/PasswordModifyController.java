package com.example.board.controller;

import com.example.board.dao.imp.PasswordChangeLogDaoImp;
import com.example.board.dto.PasswordChangeLogDto;
import com.example.board.dto.UserDto;
import com.example.board.service.UserServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/passwordModify.do")
public class PasswordModifyController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();

        resp.setContentType("text/html;charset=utf-8");
        String newPassword=req.getParameter("newPassword");
        String hashedNewPassword =BCrypt.hashpw(newPassword, BCrypt.gensalt());
        UserDto userDto= null;
        boolean modifyPassword=false;
        List<PasswordChangeLogDto> passwordChangeLogList=null;
        HttpSession session=req.getSession();
        Object user_id= session.getAttribute("user_id");
        int change_log=0;
        try{
            UserServiceImp userServiceImp=new UserServiceImp();
            userDto=userServiceImp.findUserById(user_id.toString());
            PasswordChangeLogDaoImp passwordChangeLogDaoImp=new PasswordChangeLogDaoImp();
            //체인지로그 불러와서 같은 게 있으면 함수 중단 후 리다이렉트



            PasswordChangeLogDto passwordChangeLogDto=new PasswordChangeLogDto();
            passwordChangeLogDto.setUser_id(userDto.getUser_id());
            passwordChangeLogDto.setChanged_password(hashedNewPassword);

            modifyPassword=userServiceImp.modifyPassword(userDto, hashedNewPassword);

            if(modifyPassword){
                change_log=passwordChangeLogDaoImp.insert(passwordChangeLogDto);
                System.out.println(change_log);
                
                session.invalidate();
                
                out.println("<script>");
                out.println("alert('비밀번호가 변경되었습니다. 다시 로그인해주세요.');");
                out.println("location.href='" + req.getContextPath() + "/login.jsp';");
                out.println("</script>");
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
