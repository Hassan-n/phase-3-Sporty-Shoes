package com.project.sportyshoes.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Custom implementation of UserDetails to integrate User with Spring Security.
 */
public class CustomUserDetail extends User implements UserDetails {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs a new CustomUserDetail with the provided User.
     * 
     * @param user the user to be wrapped in CustomUserDetail
     */
    public CustomUserDetail(User user) {
        super(user);
    }

    /**
     * Returns the authorities granted to the user.
     * 
     * @return a collection of GrantedAuthority
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        
        super.getRoles().forEach(role -> {
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        });
        
        return authorityList;
    }

    /**
     * Returns the password used to authenticate the user.
     * 
     * @return the password
     */
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    /**
     * Returns the username used to authenticate the user.
     * 
     * @return the username (email)
     */
    @Override
    public String getUsername() {
        return super.getEmail();
    }

    /**
     * Indicates whether the user's account has expired.
     * 
     * @return true if the account is not expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     * 
     * @return true if the account is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     * 
     * @return true if the credentials are not expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     * 
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
