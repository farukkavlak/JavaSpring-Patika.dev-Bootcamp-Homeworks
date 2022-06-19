package com.farukkavlak.hw1.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserTable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//User Entity
public class User {

    @Id
    @SequenceGenerator(name = "User",sequenceName = "user_id_seq")
    @GeneratedValue(generator = "User")
    private Integer id;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(length = 50,nullable = false)
    private String surname;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(length = 15,nullable = false)
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    private boolean isActive;

}
