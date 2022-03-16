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
//    private static String template="post-core-api is working";
    private String postId;
    @NotNull(message = "postId cannot be null")
    private String clientId;
    @NotNull
    private String postRecepientId;
    @NotNull (message = " Recipient id cannot be null")
    private String postItem;
    private String status;
    @NotNull (message = "First name of sender cannot be null")
    private String firstNameSender;
    @NotNull (message = "Last name of sender cannot be null")
    private String lastNameSender;
    @NotNull
    @Email(message = "Incorrect email")
    private String emailOfSender;
    private String firstNameRecepient;
    private String lastNameRecepient;
}
