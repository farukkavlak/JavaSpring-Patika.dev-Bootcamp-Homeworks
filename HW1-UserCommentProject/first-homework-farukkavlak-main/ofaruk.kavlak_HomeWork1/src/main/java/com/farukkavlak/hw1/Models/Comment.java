package com.farukkavlak.hw1.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CommentTable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//Comment Entity
public class Comment {

    @Id
    @SequenceGenerator(name = "Comment",sequenceName = "comment_id_seq")
    @GeneratedValue(generator = "Comment")
    private Integer id;
    @Column(length = 500,nullable = false)
    private String commentText;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date commentDate;
    @Column(nullable = false)
    private Long productId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "UserComment_fk",referencedColumnName = "id")
    public User user;
}
