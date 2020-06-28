package com.shiyi.mapper;

import com.shiyi.dao.TextBookDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TextBookMapper {

    public void save(TextBookDao dao);

    public List<TextBookDao> findAll();

    public List<TextBookDao> findByType(String type);

}
