package com.atlyakov.vshop.service.model;

import com.atlyakov.vshop.entity.enums.Access;
import com.atlyakov.vshop.entity.enums.Role;
import com.atlyakov.vshop.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


public class AppUserPrincipal implements UserDetails {

    private User user;
    private Collection<SimpleGrantedAuthority> grantedAuthorities;

    public AppUserPrincipal(User user) {
        this.user = user;
        grantedAuthorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().name())
        );
    }

    public Integer getUserId() {
        return user.getUserId();
    }

    public Role getRole() {
        return user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (user.getAccess() == Access.ACTIVE) {
            return true;
        } else if (user.getAccess() == Access.BANNED) {
            return false;
        } else {
            return false;
        }
    }
}
