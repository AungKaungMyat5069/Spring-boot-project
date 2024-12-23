package org.example.customauthenticationprovider.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;

// this is we don't want to go to UserDetailService and PassEncoder
// like token or eye validation

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    //
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if ("admin".equals(username) && "admin".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password,
                    List.of());
        }

        throw new BadCredentialsException("Bad credentials");
    }

    // this will return type same as above method
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }


}
