package com.example.UserProject.service;

import com.example.UserProject.Request.UserRequest;
import com.example.UserProject.model.User;
import com.example.UserProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;
@Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void Post(UserRequest request) {
        User user1=new User();
        user1.setUserName(request.getUserName());
        user1.setEmail(request.getEmail());
        user1.setPassword(encoder.encode(request.getPassword()));
        user1.setRole(User.Role.USER);
        System.out.println("user1 = " + user1.toString());
        userRepository.save(user1);
    }


    public List<User> FindAll() {
       return userRepository.findAll();
    }

    public User FindById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found."));
        return user;
    }

    public void UpdateById(UserRequest userRequest, Long userId) {
        User user1=userRepository.findById(userId).orElseThrow(()->new RuntimeException("Cannot update user."));
        if(userRequest.getUserName()!=null){
            user1.setUserName(userRequest.getUserName());
        }
        if(userRequest.getEmail()!=null){
            user1.setEmail(userRequest.getEmail());
        }
        if(userRequest.getPassword()!=null){
            user1.setPassword(userRequest.getPassword());
        }
        userRepository.save(user1);
    }

    public void Delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User does not exist!"));
        userRepository.delete(user);
    }
}
