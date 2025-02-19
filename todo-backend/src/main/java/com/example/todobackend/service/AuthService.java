package com.example.todobackend.service;

import com.example.todobackend.dao.RoleDao;
import com.example.todobackend.dao.UserDao;
import com.example.todobackend.dto.LoginDto;
import com.example.todobackend.dto.RegisterPerson;
import com.example.todobackend.entity.Role;
import com.example.todobackend.entity.Users;
import com.example.todobackend.exception.ReadyEmailException;
import com.example.todobackend.exception.ReadyUserNameException;
import com.example.todobackend.jwt.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final RoleDao roleDao;
    private final AuthenticationManager authenticationManager;// add this when you use login data
    private final JwtTokenProvider jwtTokenProvider;



    public AuthService(UserDao userDao, PasswordEncoder passwordEncoder, RoleDao roleDao, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.roleDao = roleDao;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String register(RegisterPerson person) {
        if(userDao.existsByUserName(person.username())) {
            throw new ReadyUserNameException();
        }
        if(userDao.existsByEmail(person.email())){
            throw new ReadyEmailException();
        }
        Role role;
        if (!roleDao.existsByName("ROLE_USER")) {
            role = new Role(null, "ROLE_USER");
        } else {
            role = roleDao.findByName("ROLE_USER").orElseThrow(() -> new UsernameNotFoundException("Some Error in 37 in AuthService"));
        }
        Users users = new Users();
        users.setUserName(person.username());
        users.setEmail(person.email());
        users.setPassword(passwordEncoder.encode(person.password()));
        users.addRole(role);
        userDao.save(users);
        return "Save the User Register";
    }

    public String loginService(LoginDto user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.usernameOrEmail(),
                        user.password()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }
}
