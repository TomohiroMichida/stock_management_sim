package com.example.demo.form;

import lombok.Data;

/**
 * ログイン画面form
 * 
 * @author michy
 */
@Data
public class LoginForm {

	/** ログインID **/
	private String loginId;

	/** パスワード **/
	private String password;
}
