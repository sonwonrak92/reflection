package com.team4.webservice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonParser;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		return "login";
	}
	@RequestMapping("/login_callback")
	public String loginCallback(HttpRequest request) {
		
		return "login_callback";
	}

}
