package com.dh.claimservice.controllers;

import com.dh.claimservice.model.Claim;
import com.dh.claimservice.service.ClaimService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClaimRestController {
  private final ClaimService claimService;

  public ClaimRestController(ClaimService claimService) {
    this.claimService = claimService;
  }

  @GetMapping("/{userId}")
  public List<Claim> findByUserId(@PathVariable String userId){
    return claimService.findByUserId(userId);
  }
}
