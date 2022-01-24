package com.carlosveigafilho.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlosveigafilho.dscatalog.dto.CategoryDTO;
import com.carlosveigafilho.dscatalog.entities.Category;
import com.carlosveigafilho.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly=true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll();
		return list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
	}
}
