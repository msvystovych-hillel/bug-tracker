package com.example.demo.configuration.security;

import com.example.demo.configuration.security.CustomUserDetails;
import com.example.demo.configuration.security.UserEntity;
import com.example.demo.configuration.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}