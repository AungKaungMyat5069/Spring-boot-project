package com.example.todobackend.service;

import com.example.todobackend.dao.UserDao;
import com.example.todobackend.entity.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserDao userDao;

    public CustomUserDetailService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        return userDao.findUserWithUsernameOrEmail(usernameOrEmail).map(SecurityUser::new).orElseThrow(
                () -> new UsernameNotFoundException(usernameOrEmail)
        );
    }
}
