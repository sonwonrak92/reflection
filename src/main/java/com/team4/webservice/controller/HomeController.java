package com.team4.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team4.webservice.service.HomeServiceImpl;


@Controller
public class HomeController {
	@Autowired
	private HomeServiceImpl service ;
	
	@GetMapping("/main")
	public String main(Model model) {
		//model.addAttribute( "items",service.findAllItems() );
		
		return "main";
	}
	

}
