package com.example.board.service;

import com.example.board.dto.UserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImpTest {

    @Test
    void login() {
    }

    @Test
    void signUp() throws Exception{
        UserDto userDto = new UserDto();
        userDto.setUser_id("test4");
        userDto.setPassword("123456");
        userDto.setUser_name("test");
        userDto.setPhone_no("01012345678");
        System.out.println(new UserServiceImp().signUp(userDto));

    }
}