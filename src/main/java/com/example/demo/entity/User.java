package com.example.demo.entity;

public class User {
  private int id;
  private String username;
  private String email;
  private String password;
  private boolean enabled;
  private String authority;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return this.enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getAuthority() {
    return this.authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

}
