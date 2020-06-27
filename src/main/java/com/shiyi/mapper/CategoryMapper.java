package com.shiyi.mapper;

import com.shiyi.dao.CategoryDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {

    public void save(CategoryDao dao);

    public List<CategoryDao> findAll();

}
