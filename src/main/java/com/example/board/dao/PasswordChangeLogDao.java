package com.example.board.dao;

import com.example.board.dto.PasswordChangeLogDto;

import java.util.List;

public interface PasswordChangeLogDao {
    int insert(PasswordChangeLogDto passwordChangeLogDto) throws Exception;
    List<PasswordChangeLogDto> findAll() throws Exception;
    List<PasswordChangeLogDto> findByUserId(int user_no) throws Exception;

}
