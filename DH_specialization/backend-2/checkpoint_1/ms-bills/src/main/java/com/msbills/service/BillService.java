package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;

    public Bill create(Bill b) {
        return repository.save(b);
    }

    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public Bill getById(String id) {
        return repository.findById(id).get();
    }


    public List<Bill> getAllByUserId(String userId) {
        return repository.findAllByIdUser(userId);
    }
}
