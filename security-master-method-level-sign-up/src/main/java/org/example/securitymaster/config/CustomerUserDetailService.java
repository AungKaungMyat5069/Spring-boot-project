package org.example.securitymaster.config;

import lombok.RequiredArgsConstructor;
import org.example.securitymaster.dao.UserDao;
import org.example.securitymaster.security.ds.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailService implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username).map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
