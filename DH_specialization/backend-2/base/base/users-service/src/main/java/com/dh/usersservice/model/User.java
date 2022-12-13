package com.dh.usersservice.model;

import java.util.List;

public class User {
  private String id;
  private String name;
  private String dni;
  private String email;
  private List<Claim> claims;

  public User(String id, String name, String dni, String email,List<Claim> claims) {
    this.id = id;
    this.name = name;
    this.dni = dni;
    this.email = email;
    this.claims = claims;
  }

  public List<Claim> getClaims() {
    return claims;
  }

  public void setClaims(List<Claim> claims) {
    this.claims = claims;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
