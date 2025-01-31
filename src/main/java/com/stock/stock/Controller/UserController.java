package com.stock.stock.Controller;
import com.stock.stock.Classes.User;
import com.stock.stock.Repository.UserRepository;
import com.stock.stock.Services.UserService;
import com.stock.stock.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUserResponse(@RequestBody User user) {
        User newUser = UserService.registerUser(user.getName(),user.getEmail(),user.getPassword(),user.getImgUrl());
        return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(UserService.getAllUsers());
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}
