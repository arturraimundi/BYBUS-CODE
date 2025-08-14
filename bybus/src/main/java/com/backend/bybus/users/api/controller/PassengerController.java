package com.backend.bybus.users.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.backend.bybus.users.model.Passenger;
import com.backend.bybus.users.service.PassengerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/passengers")
@CrossOrigin(origins = "http://localhost:4200")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

   @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.findAll();
    }

    @GetMapping("/{id}")
        public Passenger getPassengerById(@PathVariable Long id) {
            return passengerService.findById(id).orElseThrow(() -> new RuntimeException("Passenger not found"));
        }

        @GetMapping("/email/{email}")
        public Passenger getPassengerByEmail(@PathVariable String email) {
            return passengerService.findByEmail(email).orElse(null);
        }

        @GetMapping("/name/{name}")
        public List<Passenger> getPassengersByName(@PathVariable String name) {
            return passengerService.findByName(name);
        }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.save(passenger);
    }

    @PutMapping("/{id}")
        public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
            return passengerService.update(id, passenger);
        }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deleteById(id);
    }
    

}
