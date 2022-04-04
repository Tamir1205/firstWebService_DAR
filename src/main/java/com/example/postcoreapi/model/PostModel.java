package com.example.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {
    @NotNull
    private String postId;
    @NotNull
    private String clientId;
    @NotNull
    private String postRecepientId;

    @NotNull
    private String postItem;
    private String status;
    private String firstNameRecepient;
    private String lastNameRecepient;
    @NotNull(message = "Email cannot be empty")
    @Email(message = "Incorrect email")
    private String emailOfRecepient;
    @NotNull
    private String pointOfDestination;
}
