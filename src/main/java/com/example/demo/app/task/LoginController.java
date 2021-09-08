package com.example.demo.app.task;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String getLogin(LoginForm loginForm,
                    Model model) {
        model.addAttribute("title", "ログイン");

        return "login";
    }

    @PostMapping
    String postLogin(@Valid @ModelAttribute LoginForm loginForm,
                     BindingResult result,
                     Model model) {
        if (!result.hasErrors()) {
            User user = new User();
            user.setUsername(loginForm.getUsername());
            user.setPassword(loginForm.getPassword());
            user.setEmail("null");
            user.setEnabled(true);
            user.setAuthority("USER");
            userService.loadUserByUsername(user);
            return "redirect:/task";
        } else {
            model.addAttribute("loginForm", loginForm);
            model.addAttribute("title", "ログイン");
            return "/login";
        }
    }
}
