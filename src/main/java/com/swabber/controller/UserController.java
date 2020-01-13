package com.swabber.controller;

import com.swabber.controller.dto.User;
import com.swabber.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> allUserList = userService.getAllUserList();
        return new ResponseEntity<>(allUserList, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        final User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, User user) {
        userService.updateUser(id, user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<String> updatedUserAge(@PathVariable int id, @RequestParam int age) {
        userService.updatedUserAge(id, age);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
