package com.backend.bybus.auth.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.backend.bybus.auth.model.user.User;

public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByEmail(String email);
    UserDetails findByUser(String user);
    
}
//hide copilot