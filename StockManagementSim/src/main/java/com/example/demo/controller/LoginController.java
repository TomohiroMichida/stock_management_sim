package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面Controller
 * @author michy
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

	/** ログイン画面Service **/
	private final LoginService service;

	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping("/login")
	public String view(Model model, LoginForm form) {
		return "login";
	}

	/**
	 * ログイン
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@PostMapping("/login")
	public String login(Model model,LoginForm form) {
		// DBからユーザー情報を取得
		Optional<UserInfo> userInfo = service.searchUserById(form.getLoginId());

		// TODO パスワードハッシュ化対応予定
		boolean isCorrectUserAuth = userInfo.isPresent()
				&& form.getPassword().equals(userInfo.get().getPassword());

		if(true == isCorrectUserAuth) {
			return "redirect:/menu";
		} else {
			// TODO エラーメッセージをプロパティファイルに移動
			model.addAttribute("errorMsg", "ログインIDまたはパスワードに誤りがあります");
			return "login";
		}
	}
}
