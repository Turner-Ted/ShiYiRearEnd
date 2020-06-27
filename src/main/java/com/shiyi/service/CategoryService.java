package com.shiyi.service;

import com.shiyi.dao.CategoryDao;

import java.util.List;

public interface CategoryService {

    public void saveCategory(CategoryDao dao);

    public List<CategoryDao> findAllCategory();

}
