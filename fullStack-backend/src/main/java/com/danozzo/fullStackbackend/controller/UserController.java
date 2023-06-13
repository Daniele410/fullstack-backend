package com.danozzo.fullStackbackend.controller;

import com.danozzo.fullStackbackend.model.User;
import com.danozzo.fullStackbackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fullstack")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    @ResponseBody
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
    }


    @PostMapping("/user")
    public ResponseEntity<User> addNewUser(@RequestBody User newUser){
        return new ResponseEntity<>(userService.saveUser(newUser),HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{userId}")
    @ResponseBody
    public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }


}
