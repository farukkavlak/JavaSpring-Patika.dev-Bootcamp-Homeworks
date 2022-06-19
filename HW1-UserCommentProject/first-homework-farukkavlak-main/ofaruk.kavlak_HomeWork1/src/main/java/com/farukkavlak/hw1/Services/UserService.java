package com.farukkavlak.hw1.Services;

import com.farukkavlak.hw1.Dto.UserDto;
import com.farukkavlak.hw1.Dto.UserSaveRequestDto;
import com.farukkavlak.hw1.Dto.UserUpdateRequestDto;
import com.farukkavlak.hw1.Models.User;

import java.util.List;

//Interface to do some operations on the User Entity
public interface UserService {
    UserDto saveUser(UserSaveRequestDto userSaveRequestDto);
    List<UserDto> findAll();
    UserDto findById(int user_id);
    UserDto updateById(UserUpdateRequestDto userUpdateRequestDto, int updatedUser_id);
    UserDto setInactive(int user_id);
}
