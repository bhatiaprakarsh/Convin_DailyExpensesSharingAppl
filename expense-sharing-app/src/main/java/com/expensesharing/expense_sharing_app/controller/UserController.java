package com.expensesharing.expense_sharing_app.controller;

import com.expensesharing.expense_sharing_app.entity.User;
import com.expensesharing.expense_sharing_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // saare users ko map krne ke liye
public class UserController {

    @Autowired
    private UserService userService; // light coupling ke liye h dependies injection

    // endpoints serves as a request feature for every request that wee fire
    // jo maango go vahi milega
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // Return 201 Created status dedega
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user); // Return 200 OK status with the user data
    }
}

