package com.example.carsharingbackend.security;

import com.example.carsharingbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_PROCESSING_URL = "/login";
    private static final String LOGIN_FAILURE_URL = "/login?error=true";
    private static final String LOGIN_URL = "/login";
    private static final String LOGOUT_SUCCESS_URL = "/main";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder psw;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(s -> new UserDetailsImpl(userRepository.findByEmailIgnoreCase(s).get()));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .csrf().disable()
                .formLogin().loginPage(LOGIN_URL).loginProcessingUrl(LOGIN_PROCESSING_URL)
                .defaultSuccessUrl(LOGOUT_SUCCESS_URL)
                .failureUrl(LOGIN_FAILURE_URL)
                .and()
                .logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);

    }



}