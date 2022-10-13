package com.groomproject.sharedsidePJT.auth.dto;

import com.groomproject.sharedsidePJT.auth.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String email;
    private String password;
    private int age;
    private Role role;

    /* DTO -> Entity*/
    public User toEntity() {
        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .age(age)
                .role(role)
                .build();
        return user;
    }
}
