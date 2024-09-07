package com.balancee.rewardsManagementApi.security.manager;

import com.balancee.rewardsManagementApi.security.provider.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomAuthenticationProvider authenticationProvider;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Class<? extends Authentication> authenticationType = authentication.getClass();
        if(authenticationProvider.supports(authenticationType)){
            return authenticationProvider.authenticate(authentication);
        }else {
            throw new BadCredentialsException("Authentication Failed");
        }
    }
}
