package com.example.board.dao.imp;

import com.example.board.dao.BoardDao;
import com.example.board.dao.DBConnection;
import com.example.board.dto.BoardDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImp implements BoardDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public BoardDaoImp() throws Exception {
        conn= DBConnection.getConnection();
    }
    @Override
    public List<BoardDto> findAll() throws Exception {
        List<BoardDto> findAll=null;
        String sql="select * from boards order by board_id desc";
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        findAll=new ArrayList<>();
        while(rs.next()) {
            BoardDto boardDto=new BoardDto();
            boardDto.setBoard_id(rs.getInt("board_id"));
            boardDto.setTitle(rs.getString("title"));
            boardDto.setUser_no(rs.getInt("user_no"));
            boardDto.setCreated_at(rs.getString("created_at"));
            boardDto.setUser_name(rs.getString("user_name"));
            findAll.add(boardDto);
        }

        return findAll;
    }

    @Override
    public List<BoardDto> findBoardByUserName(String user_name) throws Exception {
        return List.of();
    }

    @Override
    public List<BoardDto> findBoardByTitle(String title) throws Exception {
        return List.of();
    }
}
