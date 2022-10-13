package com.groomproject.sharedsidePJT.auth.service;

import com.groomproject.sharedsidePJT.auth.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
public class CustomUserDetailsService implements UserDetails {

    private final User user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() { //계정 만료 여부 (t:만료x, f:만료o)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정 잠김 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //pw만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() { //사용자 활성화 여부
        return true;
    }

}
