package com.msusers.feign.feignmodel;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
public class BillDto {

    private String idBill;

    private String customerBill;

    private String idUser;

    private String productBill;

    private Double totalPrice;
}
