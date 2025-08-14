package com.backend.bybus.users.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.backend.bybus.users.model.User;
import com.backend.bybus.users.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUser(userDetails.getUser());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }
        return null;
    }
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;   }
        return false;  
    }


}
