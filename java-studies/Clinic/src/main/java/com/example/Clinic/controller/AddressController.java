package com.example.Clinic.controller;


import com.example.Clinic.dto.AddressDTO;
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
    public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressService.save(addressDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressDTO>> getAllAddressess() {
        return ResponseEntity.ok(addressService.searchAll());
    }

   /* @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {
        addressService.delete(id);
        Address address = addressService.findById(id);
        if( address == null)
            return ResponseEntity.ok("Deleted");
        return ResponseEntity.ok("Not Deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable Integer id) {
        return ResponseEntity.ok(addressService.update(id, address));
    }*/

}
