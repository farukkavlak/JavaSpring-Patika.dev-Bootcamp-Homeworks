package com.farukkavlak.hw1.Converter;

import com.farukkavlak.hw1.Dto.UserDto;
import com.farukkavlak.hw1.Dto.UserSaveRequestDto;
import com.farukkavlak.hw1.Models.User;
import java.util.ArrayList;
import java.util.List;

//To make some conversions about user
public class UserConverter {

    //UserSaveRequestDto -> User
    public User convertToUser(UserSaveRequestDto userSaveRequestDto){
        User user = new User();
        user.setName(userSaveRequestDto.getName());
        user.setSurname(userSaveRequestDto.getSurname());
        user.setPhoneNumber(userSaveRequestDto.getPhoneNumber());
        user.setEmail(userSaveRequestDto.getEmail());
        user.setBirthDate(userSaveRequestDto.getBirthDate());
        user.setActive(userSaveRequestDto.isActive());
        return user;
    }
    //UserDto -> User
    public User convertToUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setBirthDate(userDto.getBirthDate());
        user.setActive(userDto.isActive());
        return user;
    }
    //User -> UserDto
    public UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEmail(user.getEmail());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setActive(user.isActive());
        return userDto;
    }

    public List<UserDto> convertToUserDtoList(List<User> userList){
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            UserDto userDto = convertToUserDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }


}
