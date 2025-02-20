package com.example.board.dao;

import com.example.board.dto.LoginLogDto;

import java.util.List;

public interface LoginLogDao {
    int insert(LoginLogDto loginLogDto) throws Exception;
    List<LoginLogDto> findAll() throws Exception;
}
