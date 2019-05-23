package com.team4.webservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.team4.webservice.dto.ItemDto;

@Mapper
@Repository
public interface ItemMapper {
    
	@Select("SELECT * FROM reflection")
	List<ItemDto> selectAllItems();

	@Insert("INSERT INTO reflection (celebName, celebRate, age, ageRate, emotionValue, memo, imagePath) "
			+ "VALUES(#{celebName} , #{celebRate} , #{age}, #{ageRate}, #{emotionValue}, #{memo}, #{imagePath} )")	
	int insertData(ItemDto dto);

	@Update("update reflection set memo=#{memo} where id=#{id}")
	int updateData(ItemDto dto);

	@Delete("delete from reflection where id=#{id}")
	int deleteData(String arg);

}
