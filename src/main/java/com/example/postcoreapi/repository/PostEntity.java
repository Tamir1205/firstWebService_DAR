package com.example.postcoreapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="post_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostEntity {

    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true)
    private String postId;
    @Column(nullable = false,length = 50)

    private String clientId;
    @Column(nullable = false,length = 50)

    private String postRecepientId;

    @Column(nullable = false,length = 50)
    private String postItem;
    @Column(nullable = false,length = 50)

    private String status;
    @Column(nullable = false,length = 50)

    private String firstNameRecepient;
    @Column(nullable = false,length = 50)

    private String lastNameRecepient;
    @Column(nullable = false,length = 50)
    private String emailOfRecepient;
    @Column(nullable = false,length = 50)
    private String pointOfDestination;


}
