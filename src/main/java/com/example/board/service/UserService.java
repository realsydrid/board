package com.example.board.service;

import com.example.board.dto.UserDto;

public interface UserService {
    boolean login(String userId, String password) throws Exception;
    boolean signUp(UserDto userDto) throws Exception;
    boolean modifyPassword(UserDto userDto,String newPassword) throws Exception;
    UserDto findUserById(String userId) throws Exception;


}
