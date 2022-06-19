package com.farukkavlak.hw1.Services;

import com.farukkavlak.hw1.Converter.UserConverter;
import com.farukkavlak.hw1.Dto.UserDto;
import com.farukkavlak.hw1.Dto.UserSaveRequestDto;
import com.farukkavlak.hw1.Dto.UserUpdateRequestDto;
import com.farukkavlak.hw1.Models.User;
import com.farukkavlak.hw1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    UserConverter userConverter = new UserConverter();

    //Save with given Dto
    @Override
    public UserDto saveUser(UserSaveRequestDto userSaveRequestDto) {
        User user = userConverter.convertToUser(userSaveRequestDto);
        user = userRepository.save(user);
        UserDto userDto = userConverter.convertToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = userConverter.convertToUserDtoList(userList);
        return userDtoList;
    }

    @Override
    public UserDto findById(int user_id) {
        User user = userRepository.findById(user_id).orElseThrow();
        UserDto userDto = userConverter.convertToUserDto(user);
        return userDto;
    }

    //Update with given info and save again to the User repo
    @Override
    public UserDto updateById(UserUpdateRequestDto userUpdateRequestDto, int updatedUser_id) {
        UserDto userDto = userConverter.convertToUserDto(userRepository.findById(updatedUser_id).map(
                        user -> {
                            user.setActive(userUpdateRequestDto.isActive());
                            user.setEmail(userUpdateRequestDto.getEmail());
                            user.setBirthDate(userUpdateRequestDto.getBirthDate());
                            user.setName(userUpdateRequestDto.getName());
                            user.setSurname(userUpdateRequestDto.getSurname());
                            user.setPhoneNumber(userUpdateRequestDto.getPhoneNumber());
                            return userRepository.save(user);
                        })
                .orElseThrow());
        return userDto;
    }

    @Override
    public UserDto setInactive(int user_id) {
        User selectedUser = userRepository.findById(user_id).orElseThrow();
        selectedUser.setActive(Boolean.FALSE);
        userRepository.save(selectedUser);
        UserDto selectedUserDto = userConverter.convertToUserDto(selectedUser);
        return selectedUserDto;
    }
}
