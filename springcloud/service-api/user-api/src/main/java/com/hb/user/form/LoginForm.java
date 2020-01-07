package com.hb.user.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    @NotBlank
    String phone;

    @NotBlank
    String password;



}
