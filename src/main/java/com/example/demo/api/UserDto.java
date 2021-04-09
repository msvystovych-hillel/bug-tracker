package com.example.demo.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    interface New {
    }

    interface Exist {
    }

    interface UpdateName extends Exist {
    }

    @Null(groups = {New.class})
    @NotNull(groups = {UpdateName.class})
    private Long id;

    @NotNull(groups = {New.class, UpdateName.class})
    private String name;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateName.class})
    private String login;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateName.class})
    private String password;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateName.class})
    @Email(groups = {New.class})
    private String email;
}