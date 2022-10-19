package com.johnoro.cpm.controller;

import com.johnoro.cpm.model.FakeUser;
import com.johnoro.cpm.service.FakeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private FakeUserService fakeUserService;

    @PostMapping("/register")
    public String register(@RequestBody FakeUser user) {
        return fakeUserService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody FakeUser user) {
        return fakeUserService.login(user);
    }
}
