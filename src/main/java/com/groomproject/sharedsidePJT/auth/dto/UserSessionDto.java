package com.groomproject.sharedsidePJT.auth.dto;

import com.groomproject.sharedsidePJT.auth.entity.User;

import javax.management.relation.Role;
import java.io.Serializable;

public class UserSessionDto implements Serializable {

    private String name;
    private String email;
    private String password;
    private int age;
    private Role role;

    /* Entity -> Dto */
    public UserSessionDto(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.age = user.getAge();
        this.role = user.getRole();
    }
}
