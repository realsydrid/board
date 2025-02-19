package com.example.board.service;

import com.example.board.dao.DBConnection;
import com.example.board.dao.UserDao;
import com.example.board.dao.UserDaoImp;
import com.example.board.dto.UserDto;

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
        return false;
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
}
