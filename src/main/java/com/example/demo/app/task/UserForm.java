package com.example.demo.app.task;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

  @NotNull(message = "※ユーザー名を入力してください。")
  @Size(max = 50, message = "※50文字以内で入力してください。")
  private String username;

  @NotNull(message = "※メールアドレスを入力してください。")
  private String email;

  @NotNull(message = "※パスワードを入力してください。")
  @Size(min = 6, max = 20, message = "※6文字以上20文字以内で入力してください。")
  private String password;

  public UserForm() {
  }

  public UserForm(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
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

}
