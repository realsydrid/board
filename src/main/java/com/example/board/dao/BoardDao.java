package com.example.board.dao;

import com.example.board.dto.BoardDto;

import java.util.List;

public interface BoardDao {
    List<BoardDto> findAll() throws Exception;
    List<BoardDto> findBoardByUserName(String user_name) throws Exception;
    List<BoardDto> findBoardByTitle(String title) throws Exception;
}
