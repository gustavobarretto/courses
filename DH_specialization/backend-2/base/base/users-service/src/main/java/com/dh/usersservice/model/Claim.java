package com.dh.usersservice.model;

public class Claim {
  private String id;
  private String motive;
  private String status;
  private String comments;
  private String userId;

  public Claim(String id, String motive, String status, String comments, String userId) {
    this.id = id;
    this.motive = motive;
    this.status = status;
    this.comments = comments;
    this.userId = userId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMotive() {
    return motive;
  }

  public void setMotive(String motive) {
    this.motive = motive;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
