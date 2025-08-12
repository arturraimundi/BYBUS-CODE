package com.backend.bybus.users.service;

import com.backend.bybus.users.model.Owner;
import com.backend.bybus.users.repository.OwnerRepository;
import com.backend.bybus.users.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.backend.bybus.users.model.User;
@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }

    public Owner save(Owner owner) {
        if(owner.getUser() == null){
            User user = new User();
            user.setEmail(owner.getEmail());
            user.setUser(owner.getName());
            user.setPassword("defaultPassword"); // Set a default password or handle it as needed
            owner.setUser(userRepository.save(user));
            return ownerRepository.save(owner);
        } 
        return ownerRepository.save(owner);
    }

        public Owner update(Long id, Owner ownerDetails) {
            return ownerRepository.findById(id)
                .map(owner -> {
                    owner.setName(ownerDetails.getName());
                    owner.setEmail(ownerDetails.getEmail());
                    // Adicione outros campos conforme necessário
                    return ownerRepository.save(owner);
                })
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        }

        public Optional<Owner> findByEmail(String email) {
            return ownerRepository.findByEmail(email);
        }

        public List<Owner> findByName(String name) {
            return ownerRepository.findByName(name);
        }

    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
