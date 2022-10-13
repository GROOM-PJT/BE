package com.groomproject.sharedsidePJT.auth.entity;

import lombok.*;

import javax.management.relation.Role;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;    //회원명

    @Column(nullable = false, unique = true)
    private String email;   //이메일

    @Column(nullable = false)
    private String password;    //비밀번호

    private int age;    //나이

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role gender;  //성별

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;  //역할
}
