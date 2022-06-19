package com.farukkavlak.hw1.Dto;

import lombok.Data;

import java.util.Date;
//UserUpdateRequestDto to get infos for update User
@Data
public class UserUpdateRequestDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private boolean isActive;
}
