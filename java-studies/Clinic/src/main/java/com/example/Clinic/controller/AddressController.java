package com.example.Clinic.controller;


import com.example.Clinic.service.impl.AddressServiceImpl;
import com.example.Clinic.persistence.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/add")
    public ResponseEntity<Address> saveAddress(Address address) {
        return ResponseEntity.ok(addressService.save(address));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddressess() {
        return ResponseEntity.ok(addressService.searchAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {
        addressService.delete(id);
        Address address = addressService.findById(id);
        if( address == null)
            return ResponseEntity.ok("Deleted");
        return ResponseEntity.ok("Not Deleted");
    }

    @PutMapping("/update")
    public ResponseEntity<Address> updateAddress(Address address) {
        return ResponseEntity.ok(addressService.update(address));
    }

}
