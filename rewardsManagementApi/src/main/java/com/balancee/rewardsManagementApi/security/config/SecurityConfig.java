package com.balancee.rewardsManagementApi.security.config;

import com.balancee.rewardsManagementApi.security.filters.CustomAuthorizationFilter;
import com.balancee.rewardsManagementApi.security.filters.CustomUsernamePasswordAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    private final AuthenticationManager authenticationManager;
    private final CustomAuthorizationFilter authorizationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       var authenticationFilter =
               new CustomUsernamePasswordAuthenticationFilter(authenticationManager);
               authenticationFilter.setFilterProcessesUrl("/api/auth");
        return http.csrf(c->c.disable())
                .cors(c->c.disable())
                .sessionManagement(c->c.sessionCreationPolicy(STATELESS))
                .addFilterAt(authenticationFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(authorizationFilter,
                        CustomUsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(c->c.requestMatchers(POST, "/api/auth").permitAll()
                        .requestMatchers("/api/rewards").hasAuthority("CUSTOMER")
                        .requestMatchers("/api/rewards").permitAll()
                        .requestMatchers("/api/rewards/history").permitAll()
                        .requestMatchers("/api/rewards/balance").permitAll()
                        .requestMatchers("/api/rewards/balance").hasAuthority("CUSTOMER")
                        .requestMatchers("/api/rewards/history").hasAuthority("CUSTOMER"))
                .build();
    }



}
