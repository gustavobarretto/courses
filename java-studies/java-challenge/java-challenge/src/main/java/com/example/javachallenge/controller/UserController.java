package com.example.javachallenge.controller;

import com.example.javachallenge.model.User;
import com.example.javachallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User userCreated = userService.create(user);
        return ResponseEntity.ok(userCreated);
    }

    @PutMapping("/desactivate/{id}/{status}")
    public ResponseEntity<User> desactivate(@PathVariable Integer id,
                                            @PathVariable Boolean status) {
        User userDesactived = userService.desactivateAccount(id, status);
        return ResponseEntity.ok(userDesactived);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User userUpdated = userService.update(user);
        return ResponseEntity.ok(userUpdated);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        User userGetted = userService.get(id);
        return ResponseEntity.ok(userGetted);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
