package com.shiyi.service.impl;

import com.shiyi.dao.CategoryDao;
import com.shiyi.mapper.CategoryMapper;
import com.shiyi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper mapper;

    @Override
    public void saveCategory(CategoryDao dao) {
        mapper.save(dao);
    }

    @Override
    public List<CategoryDao> findAllCategory() {
        return mapper.findAll();
    }
}
