package com.example.board.dao;

import com.example.board.dto.PasswordChangeLogDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PasswordChangeLogDaoImp implements PasswordChangeLogDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;


    @Override
    public int insert(PasswordChangeLogDto passwordChangeLogDto) throws Exception {
        int insert=0;
        String sql="insert into password_change_logs (user_id,changed_password)values(?,?)";
        ps=conn.prepareStatement(sql);
        ps.setString(1,passwordChangeLogDto.getUser_id());
        ps.setString(2,passwordChangeLogDto.getChanged_password());
        insert=ps.executeUpdate();
        return insert;
    }

    public PasswordChangeLogDaoImp() throws Exception{
        conn=DBConnection.getConnection();
    }
    @Override
    public List<PasswordChangeLogDto> findAll() throws Exception{
        return List.of();
    }

    @Override
    public List<PasswordChangeLogDto> findByUserId(int user_no) throws Exception{
        List<PasswordChangeLogDto> findByUserId=null;
        String sql="select * from password_change_logs where user_no=?";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,user_no);
        rs=ps.executeQuery();
        while(rs.next()){
            PasswordChangeLogDto passwordChangeLogDto=new PasswordChangeLogDto();
            passwordChangeLogDto.setUser_no(rs.getInt("user_no"));
            passwordChangeLogDto.setChanged_password(rs.getString("changed_password"));
            passwordChangeLogDto.setChange_log_id(rs.getInt("change_log_id"));
            passwordChangeLogDto.setCreated_at(rs.getString("created_at"));
            findByUserId.add(passwordChangeLogDto);
        }
        return findByUserId;
    }
}
