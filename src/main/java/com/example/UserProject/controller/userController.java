package com.example.UserProject.controller;

import com.example.UserProject.Request.UserRequest;
import com.example.UserProject.model.User;
import com.example.UserProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
public class userController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public void CreateUser(@RequestBody UserRequest request) {
        userService.Post(request);
    }

    @GetMapping("/findAll")
    public List<User> FindAll() {
       return userService.FindAll();

    }

    @GetMapping("/findById/{userId}")
    public User FindById(@PathVariable Long userId) {
        return userService.FindById(userId);

    }

    @PutMapping("/Update/{userId}")
    public void UpdateById(@RequestBody UserRequest userRequest,@PathVariable Long userId) {
        userService.UpdateById(userRequest,userId);

    }

    @DeleteMapping("/Delete/{userId}")
    public void Delete(@PathVariable Long userId) {
        userService.Delete(userId);

    }
}
