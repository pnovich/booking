package com.example.springdata2.Service.impl;

import com.example.springdata2.Entities.Category;
import com.example.springdata2.Repository.CategoryRepository;
import com.example.springdata2.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category findCategory(long id){ return categoryRepository.findOne(id);}
}
