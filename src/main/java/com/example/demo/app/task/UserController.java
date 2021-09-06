package com.example.demo.app.task;

import javax.validation.Valid;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // 会員登録画面の表示
  @GetMapping
  public String user(UserForm userForm, Model model) {

    model.addAttribute("title", "会員登録");

    return "task/user";
  }

  @PostMapping("insert")
  public String insert(@Valid @ModelAttribute UserForm userForm, BindingResult result, Model model) {
    if (!result.hasErrors()) {
      User user = new User();
      user.setUsername(userForm.getUsername());
      user.setEmail(userForm.getEmail());
      user.setPassword(userForm.getPassword());
      user.setEnabled(true);
      user.setAuthority("USER");

      userService.insert(user);

      return "redirect:/user";
    } else {
      model.addAttribute("taskForm", userForm);
      model.addAttribute("title", "会員登録");
      return "task/user";
    }
  }
}
