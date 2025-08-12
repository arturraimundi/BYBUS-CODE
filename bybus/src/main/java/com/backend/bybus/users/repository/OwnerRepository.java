package com.backend.bybus.users.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bybus.users.model.Owner;
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{
	java.util.Optional<Owner> findByEmail(String email);
	java.util.List<Owner> findByName(String name);
}
