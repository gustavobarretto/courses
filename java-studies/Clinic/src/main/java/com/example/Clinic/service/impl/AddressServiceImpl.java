package com.example.Clinic.service.impl;

import com.example.Clinic.dto.AddressDTO;
import com.example.Clinic.persistence.entities.Address;
import com.example.Clinic.persistence.repository.impl.AddressRepositoryImpl;
import com.example.Clinic.service.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IClinicService<AddressDTO> {

    @Autowired
    private AddressRepositoryImpl addressRepository;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        return addressRepository.saveAddress(addressDTO);
    }

    @Override
    public AddressDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<AddressDTO> searchAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public AddressDTO update(Integer id, AddressDTO addressDTO) {
        return null;
    }

   /* @Override
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
    public Address update(Integer id, Address address) {
        return addressRepository.updateAddress(address);
    }*/
}
