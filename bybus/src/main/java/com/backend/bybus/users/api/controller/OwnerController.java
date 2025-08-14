package com.backend.bybus.users.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.backend.bybus.users.model.Owner;
import com.backend.bybus.users.service.OwnerService;
import java.util.List;


@RestController
@RequestMapping("/api/owners")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {
    
    @Autowired
    private OwnerService ownerService;
    
      @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
        public Owner getOwnerById(@PathVariable Long id) {
            return ownerService.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        }

        @GetMapping("/email/{email}")
        public Owner getOwnerByEmail(@PathVariable String email) {
            return ownerService.findByEmail(email).orElse(null);
        }

        @GetMapping("/name/{name}")
        public List<Owner> getOwnersByName(@PathVariable String name) {
            return ownerService.findByName(name);
        }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @PutMapping("/{id}")
        public Owner updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
            return ownerService.update(id, owner);
        }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteById(id);
    }
}
