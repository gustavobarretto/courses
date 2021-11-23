package com.example.Clinic.service.impl;

import com.example.Clinic.persistence.entities.Address;
import com.example.Clinic.impl.AddressRepositoryImpl;
import com.example.Clinic.service.IClinicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IClinicService<Address> {

    private AddressRepositoryImpl addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.saveAddress(address);
    }

    @Override
    public Address findById(Integer id) {
        return addressRepository.searchAddressById(id);
    }

    @Override
    public List<Address> searchAll() {
        return addressRepository.findAllAddresses();
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteAddress(id);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.updateAddress(address);
    }
}
