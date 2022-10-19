package com.johnoro.cpm.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private EncoderProvider encoderProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
                .disable() // TODO: implement properly
                // .sessionManagement(sm -> {
                //     sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                // })
            //    .addFilter()
            //    .addFilterAfter()
                .authorizeRequests(ar -> {
                    ar.antMatchers("/api/**").authenticated();
                    // ar.antMatchers("/login").permitAll();
                })
                .httpBasic() // TODO: update to use jwts properly
                .and().build();
                // .build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(encoderProvider.passwordEncoder());
        return auth.build();
    }
}
