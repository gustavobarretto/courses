package com.msusers.service;


import com.msusers.feign.BillFeign;
import com.msusers.feign.feignmodel.BillDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BillFeign billService;

    public List<BillDto> createBills(List<BillDto> u) {

        String idUser = SecurityContextHolder.getContext().getAuthentication().getName();

        List<BillDto> updatedBillsList = u.stream()
                .map(bill -> {
                    bill.setIdUser(idUser);
                    return billService.createBill(bill);
                }).toList();

        return updatedBillsList;
    }

    public List<BillDto> getBills(String idUser) {
        return billService.getBillById(idUser);
    }
}
