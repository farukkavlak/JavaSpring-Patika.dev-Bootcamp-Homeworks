package com.farukkavlak.hw1.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;

//Dto for comment to show user info about User Entity
@Data
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private boolean isActive;
}
