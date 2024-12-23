package org.example.securitymaster.service;

import lombok.RequiredArgsConstructor;
import org.example.securitymaster.dao.UserDao;
import org.example.securitymaster.security.ds.Role;
import org.example.securitymaster.security.ds.SignUpModel;
import org.example.securitymaster.security.ds.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpModel signUpModel) {
        User user = new User(signUpModel.getUsername(), passwordEncoder.encode(signUpModel.getPassword()));
        String[] roles = signUpModel.getRoles().split(",");
        if (roles.length > 0) {
//           for (String role : roles) {
//               Role roleObj = new Role();
//               roleObj.setName("ROLE_" + role.trim());
//               user.addRole(roleObj);
//
//           }
           Arrays.stream(roles).map(r -> new Role("ROLE_" + r.trim())).forEach(user::addRole);
        } else  {
            user.addRole(new Role("ROLE_DUMMY"));
        }

        userDao.save(user);

    }
}
