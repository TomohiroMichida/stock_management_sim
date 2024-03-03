package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginForm;


@Controller
public class LoginController {

	// TODO DB結合後に削除
	private static final String LOGIN_ID = "user";
	private static final String PASSWORD = "pwd";

	@GetMapping("/login")
	public String view(Model model, LoginForm form) {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model,LoginForm form) {
		boolean isCorrectUserAuth = form.getLoginId().equals(LOGIN_ID)
				&& form.getPassword().equals(PASSWORD);

		if(true == isCorrectUserAuth) {
			return "redirect:/menu";
		} else {
			model.addAttribute("errorMsg", "ログインIDまたはパスワードに誤りがあります");
			return "login";
		}
	}
}
