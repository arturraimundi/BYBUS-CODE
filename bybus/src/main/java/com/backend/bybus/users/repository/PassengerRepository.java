package com.backend.bybus.users.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bybus.users.model.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	java.util.Optional<Passenger> findByEmail(String email);
	java.util.List<Passenger> findByName(String name);
}