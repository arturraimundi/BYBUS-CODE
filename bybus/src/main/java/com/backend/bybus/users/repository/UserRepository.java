package com.backend.bybus.users.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bybus.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
} 
