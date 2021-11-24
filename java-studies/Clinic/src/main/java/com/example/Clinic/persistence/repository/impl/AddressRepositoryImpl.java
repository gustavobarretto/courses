package com.example.Clinic.persistence.repository.impl;

import com.example.Clinic.dto.AddressDTO;
import com.example.Clinic.persistence.entities.Address;
import com.example.Clinic.persistence.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AddressRepositoryImpl {
    private static Map<Integer, AddressDTO> addressDTOMap = new HashMap<>();

    @Autowired
    private IAddressRepository iAddressRepository;

    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address addressToBeSaved = iAddressRepository.save(new Address(addressDTO));
        addressDTO.setId(addressToBeSaved.getId());
        addressDTOMap.put(addressDTO.getId(), addressDTO);
        return addressDTO;
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
