package com.jm.jwttest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("user")) {
            return null;
        }

        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        user.setUserRole(roles);
        return user;
    }
}
