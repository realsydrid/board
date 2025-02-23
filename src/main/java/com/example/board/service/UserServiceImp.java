package com.example.board.service;

import com.example.board.dao.DBConnection;
import com.example.board.dao.UserDao;
import com.example.board.dao.imp.UserDaoImp;
import com.example.board.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;

public class UserServiceImp implements UserService {
    UserDao userDao;
    Connection conn;
    public UserServiceImp() throws Exception{
        conn= DBConnection.getConnection();
        userDao=new UserDaoImp(conn);
    }
    @Override
    public boolean login(String userId, String password) throws Exception {
        boolean login=false;
        UserDto userDto=userDao.findUserById(userId);

        if(BCrypt.checkpw(password,userDto.getPassword()) && userDto.getUser_id().equals(userId)){
            login=true;
        }
        return login;
    }

    @Override
    public boolean signUp(UserDto userDto) throws Exception{
        boolean signUp=false;
        int insert=0;
        try {
            conn.setAutoCommit(false);
            conn.commit();
            insert=userDao.insert(userDto);
            conn.commit();
        }catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);

        }finally {
            if(conn!=null){
                conn.close();
            }
        }

        if(insert>0){
            signUp=true;
        }
        return signUp;
    }

    @Override
    public boolean modifyPassword(UserDto userDto,String newPassword) throws Exception {
        boolean modifyPassword=false;
        int update=0;
        conn.setAutoCommit(false);
        conn.commit();
        try{
            update=userDao.updatePassword(userDto,newPassword);
            if(update>0){
                modifyPassword=true;
            }
            conn.commit();
        }catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }
        return modifyPassword;
    }

    @Override
    public UserDto findUserById(String userId) throws Exception {
        UserDto findUserById;
        findUserById = userDao.findUserById(userId);
        return findUserById;
    }
}
