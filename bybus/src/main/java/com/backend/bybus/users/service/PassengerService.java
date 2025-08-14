package com.backend.bybus.users.service;

import com.backend.bybus.users.model.Passenger;
import com.backend.bybus.users.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.backend.bybus.users.model.User;
import com.backend.bybus.users.repository.UserRepository;
@Service
public class PassengerService {

    @Autowired
    private final PassengerRepository passengerRepository;
    @Autowired
    private UserRepository userRepository;

    
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> findById(Long id) {
        return passengerRepository.findById(id);
    }

    public Optional<Passenger> findByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }

    public List<Passenger> findByName(String name) {
        return passengerRepository.findByName(name);
    }

    public Passenger save(Passenger passenger) {
        if(passenger.getUser() == null) {
            User user = new User();
            user.setEmail(passenger.getEmail());
            user.setUser(passenger.getName());
            user.setPassword("defaultPassword");
            passenger.setUser(userRepository.save(user));
        }
        return passengerRepository.save(passenger);
    }

        public Passenger update(Long id, Passenger passengerDetails) {
            return passengerRepository.findById(id)
                .map(passenger -> {
                    passenger.setName(passengerDetails.getName());
                    passenger.setEmail(passengerDetails.getEmail());
                    return passengerRepository.save(passenger);
                })
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        }

    public void deleteById(Long id) {
        passengerRepository.deleteById(id);
    }
}
