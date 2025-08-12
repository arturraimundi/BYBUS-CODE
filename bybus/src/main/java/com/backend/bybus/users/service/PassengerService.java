package com.backend.bybus.users.service;

import com.backend.bybus.users.model.Passenger;
import com.backend.bybus.users.repository.PassangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassangerRepository passengerRepository;

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> findById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

        public Passenger update(Long id, Passenger passengerDetails) {
            return passengerRepository.findById(id)
                .map(passenger -> {
                    passenger.setName(passengerDetails.getName());
                    passenger.setEmail(passengerDetails.getEmail());
                    // Adicione outros campos conforme necessário
                    return passengerRepository.save(passenger);
                })
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        }

    public void deleteById(Long id) {
        passengerRepository.deleteById(id);
    }
}
