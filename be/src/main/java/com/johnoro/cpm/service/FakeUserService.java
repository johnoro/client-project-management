package com.johnoro.cpm.service;

import com.johnoro.cpm.config.security.EncoderProvider;
import com.johnoro.cpm.config.security.jwt.JwtProvider;
import com.johnoro.cpm.model.FakeUser;
import com.johnoro.cpm.repository.FakeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class FakeUserService {
   @Autowired
   private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private FakeUserRepository fakeUserRepository;

    @Autowired
    private EncoderProvider encoderProvider;

    public String register(FakeUser user) {
        String encodedPassword = encodePassword(user.getPassword());
        user.setPassword(encodedPassword);
        fakeUserRepository.save(user);
         return login(user);
    }

    public String login(FakeUser user) {
        Authentication authentication =
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword()
                )
            );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);
        
        // shorter alt.; it's probably preferred to do it the way above
        // return jwtProvider.generateToken(user);
    }

    private String encodePassword(String password) {
        return encoderProvider
                .passwordEncoder()
                .encode(password);
    }
}
