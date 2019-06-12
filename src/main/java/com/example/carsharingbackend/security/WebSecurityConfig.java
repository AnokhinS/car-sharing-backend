package com.example.carsharingbackend.security;

import com.example.carsharingbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_PROCESSING_URL = "/login";
    private static final String LOGIN_FAILURE_URL = "/login?error=true";
    private static final String LOGIN_URL = "/login";
    private static final String LOGIN_SUCCESS_URL = "/myprofile";
    private static final String LOGOUT_SUCCESS_URL = "/main";
    private static final String REGISTRATION_URL = "/registration";

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
                .authorizeRequests().antMatchers("/myprofile").authenticated()
                .and()
                .formLogin().loginPage(LOGIN_URL).loginProcessingUrl(LOGIN_PROCESSING_URL)
                .defaultSuccessUrl(LOGIN_SUCCESS_URL, true)
                .failureUrl(LOGIN_FAILURE_URL)
                .and()
                .logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);

        http.authorizeRequests().anyRequest().permitAll();

//        http
//                .authorizeRequests().antMatchers(REGISTRATION_URL,LOGIN_URL).permitAll();
//                .and()
//                .authorizeRequests().anyRequest().authenticated();

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                // Vaadin Flow static resources
                "/VAADIN/**",

                // the standard favicon URI
                "/favicon.ico",

                // the robots exclusion standard
                "/robots.txt",

                // web application manifest
                "/manifest.webmanifest",
                "/sw.js",
                "/offline-page.html",

                // icons and images
                "/icons/**",
                "/images/**",

                // (development mode) static resources
                "/frontend/**",

                // (development mode) webjars
                "/webjars/**",

                // (development mode) H2 debugging console
                "/h2-console/**",

                // (production mode) static resources
                "/frontend-es5/**", "/frontend-es6/**");
    }

}