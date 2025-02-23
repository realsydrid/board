package com.example.board.dao;

import com.example.board.dto.LoginLogDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class LoginLogDaoImp implements LoginLogDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    public LoginLogDaoImp() throws Exception{
        conn=DBConnection.getConnection();
    }

    @Override
    public int insert(LoginLogDto loginLogDto) throws Exception {
        int insert = 0;

        String sql = "insert into login_logs (user_no,ip_address,browser)values(?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, loginLogDto.getUser_no());
        ps.setString(2, loginLogDto.getIp_address());
        ps.setString(3, loginLogDto.getBrowser());
        insert = ps.executeUpdate();
        return insert;
    }

    @Override
    public List<LoginLogDto> findAll() throws Exception {
        return List.of();
    }
}
