package com.team4.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.webservice.dto.ItemDto;
import com.team4.webservice.mapper.ItemMapper;

@Service
public class HomeServiceImpl {
	
	@Autowired
	private ItemMapper mapper;
	
	public List<ItemDto> findAllItems(){
		return mapper.selectAllItems();
	};
	
	public int insertItem(ItemDto dto) {
		return mapper.insertData(dto);
	};
	
	public int updateItem(ItemDto dto) {
		return mapper.updateData(dto);
	};
	
	public int deleteItem(String id) {
		return mapper.deleteData(id);
	};

}
