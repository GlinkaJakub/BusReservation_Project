package com.glinka.mtab.model.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserDto {

    private Long id;
    private String login;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Long roleId;
}
