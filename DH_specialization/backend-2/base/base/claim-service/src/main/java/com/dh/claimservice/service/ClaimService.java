package com.dh.claimservice.service;

import com.dh.claimservice.model.Claim;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

  public List<Claim> findByUserId(String userId){
    return List.of(new Claim("asdf-sdf-","me cobraram duas vezes","pendente","",userId));
  }
}
