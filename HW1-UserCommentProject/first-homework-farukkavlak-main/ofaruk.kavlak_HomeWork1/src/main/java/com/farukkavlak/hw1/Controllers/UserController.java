package com.farukkavlak.hw1.Controllers;

import com.farukkavlak.hw1.Dto.UserDto;
import com.farukkavlak.hw1.Dto.UserSaveRequestDto;
import com.farukkavlak.hw1.Dto.UserUpdateRequestDto;
import com.farukkavlak.hw1.Models.User;
import com.farukkavlak.hw1.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //To save user with given UserSaveRequestDto
    @PostMapping("saveUser")
    public ResponseEntity saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        userService.saveUser(userSaveRequestDto);
        return new ResponseEntity(userSaveRequestDto, HttpStatus.CREATED);
    }

    //To find all users
    @GetMapping("findAll")
    public ResponseEntity findAll(){
        List<UserDto> userList = userService.findAll();
        return ResponseEntity.ok(userList);
    }

    //To find user with given id
    @GetMapping("findById/{user_id}")
    public ResponseEntity findUserById(@PathVariable("user_id") int user_id){
        UserDto userWithThisId = userService.findById(user_id);
        return ResponseEntity.ok(userWithThisId);
    }

    //To update user with given id and UserUpdateRequestDto
    @PutMapping("updateById/{updatedUser_id}")
    public ResponseEntity updateById(@RequestBody UserUpdateRequestDto userUpdateRequestDto, @PathVariable int updatedUser_id){
        UserDto replacedUser = userService.updateById(userUpdateRequestDto,updatedUser_id);
        return ResponseEntity.ok(replacedUser);
    }

    //To set inactive selected user with given id
    @PatchMapping("setInactive/{user_id}")
    public ResponseEntity setInactive(@PathVariable("user_id") int user_id){
        UserDto selectedUser = userService.setInactive(user_id);
        return ResponseEntity.ok(selectedUser);
    }
}
