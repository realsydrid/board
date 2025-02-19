package com.example.board.dao;

import com.example.board.dto.UserDto;

public interface UserDao {
    int insert (UserDto userDto) throws Exception;
    int update(UserDto userDto) throws Exception;
    int updatePassword(UserDto userDto, String newPassword) throws Exception;
    int delete(String userId) throws Exception;
    UserDto findUserById(String userId) throws Exception;


}
