package org.example.daoauthenticationprovider;

import lombok.RequiredArgsConstructor;
import org.example.daoauthenticationprovider.dao.EmployeeDao;
import org.example.daoauthenticationprovider.userdetails.EmployeeUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.security.Security;
@Component
@RequiredArgsConstructor
public class EmployeeUserDetailsService implements UserDetailsService {

    private final EmployeeDao employeeDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeDao.findEmployeeByName(username).map(EmployeeUserDetails::new).orElseThrow();
    }
}
