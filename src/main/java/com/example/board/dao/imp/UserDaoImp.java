package com.example.board.dao;

import com.example.board.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImp implements UserDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    public UserDaoImp(Connection conn) {
        this.conn=conn;
    }
    @Override
    public int insert(UserDto userDto) throws Exception{
        int insert=0;
        String sql="insert into users (user_id, user_name,password,phone_no) values(?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userDto.getUser_id());
        ps.setString(2, userDto.getUser_name());
        ps.setString(3, userDto.getPassword());
        ps.setString(4, userDto.getPhone_no());
        insert=ps.executeUpdate();



        return insert;
    }

    @Override
    public int update(UserDto userDto) throws Exception{
        return 0;
    }

    @Override
    public int updatePassword(UserDto userDto, String newPassword) throws Exception{
        int updatePassword=0;
        String sql="update users set password=? where user_id=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, newPassword);
        ps.setString(2, userDto.getUser_id());
        updatePassword=ps.executeUpdate();
        return updatePassword;
    }

    @Override
    public int delete(String userId) throws Exception{
        return 0;
    }

    @Override
    public UserDto findUserById(String userId) throws Exception{
        UserDto findUserById=null;
        String sql="select * from users where user_id=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userId);
        rs=ps.executeQuery();
        if(rs.next()){
            findUserById=new UserDto();
            findUserById.setUser_id(rs.getString("user_id"));
            findUserById.setUser_name(rs.getString("user_name"));
            findUserById.setPassword(rs.getString("password"));
            findUserById.setPhone_no(rs.getString("phone_no"));
            findUserById.setUser_no(rs.getInt("user_no"));

        }
        return findUserById;
    }
}
