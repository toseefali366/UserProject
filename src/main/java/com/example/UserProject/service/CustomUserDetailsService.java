package com.example.UserProject.service;

import com.example.UserProject.model.UserSecurity;
import com.example.UserProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserSecurity userMotFound = userRepository.findByEmail(email).map(UserSecurity::new)
                .orElseThrow(() -> new UsernameNotFoundException("User mot found"));
        System.out.println(userMotFound.getUsername()+"  "+userMotFound.getPassword()+"  "+userMotFound.getAuthorities());
        return userMotFound;
    }
}
