package com.adnan.journalApp.controller;

import com.adnan.journalApp.entry.User;
import com.adnan.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    private ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create-admin-user")
    private ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            userService.saveAdminUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating user", HttpStatus.BAD_REQUEST);
        }
    }
}
