package com.example.Clinic.impl;

import com.example.Clinic.dto.AddressDTO;
import com.example.Clinic.persistence.entities.Address;
import com.example.Clinic.persistence.repository.IAddressRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressRepositoryImpl {
    private static Map<Integer, AddressDTO> addressDTOMap = new HashMap<>();

    private IAddressRepository iAddressRepository;

    public Address saveAddress(Address address) {
        Address addressSaved = iAddressRepository.save(address);
        AddressDTO addressDTO = new AddressDTO(address);
        addressDTOMap.put(addressSaved.getId(), addressDTO);
        return addressSaved;
    }

    public Address searchAddressById(Integer id) {
        Address addressSearched = iAddressRepository.getById(id);
        AddressDTO addressDTO = addressDTOMap.get(addressSearched.getId());
        if(addressDTO != null)
            return new Address(addressDTO);
        return null;
    }

    public List<Address> findAllAddresses() {
        return iAddressRepository.findAll();
    }

    public void deleteAddress(Integer id) {
        iAddressRepository.deleteById(id);
        addressDTOMap.remove(id);
    }

    public Address updateAddress(Address address) {
        return null;
    }



}
