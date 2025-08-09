package com.adnan.journalApp.controller;

import com.adnan.journalApp.entry.User;
import com.adnan.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;


    @PostMapping
    private void createUser(@RequestBody User user) {
        userService.saveNewUser(user);
    }
}
