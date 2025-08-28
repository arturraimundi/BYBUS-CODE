package com.backend.bybus.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.bybus.auth.repository.user.UserRepository;
import com.backend.bybus.auth.model.user.User;


@Service
public class AuthorizationService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        return userRepository.findByUser(arg0);    
    }
    
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
