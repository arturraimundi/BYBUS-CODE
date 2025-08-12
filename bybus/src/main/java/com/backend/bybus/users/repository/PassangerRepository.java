package com.backend.bybus.users.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bybus.users.model.Passenger;
@Repository
public interface PassangerRepository extends JpaRepository<Passenger, Long>{
    
}