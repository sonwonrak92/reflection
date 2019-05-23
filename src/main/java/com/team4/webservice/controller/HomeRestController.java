package com.team4.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team4.webservice.dto.ItemDto;
import com.team4.webservice.service.HomeServiceImpl;

import lombok.AllArgsConstructor;

@RestController
public class HomeRestController {
	@Autowired
	private HomeServiceImpl service;	

	 @PostMapping("/save")
	 public String createItem(@RequestBody ItemDto dto)	 {
		 service.insertItem(dto);
		 return "HTTP POST was called";
	 }
	 
	 @PutMapping("/update/{id}")
	 public String updateItem(@RequestBody ItemDto dto)	 {
		 service.updateItem(dto);
		 return "HTTP PUT was called";
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public String deleteItem(@PathVariable String id)	 {
		 service.deleteItem(id);	  
		 return "HTTP delete was called";
	 }
	 
}
