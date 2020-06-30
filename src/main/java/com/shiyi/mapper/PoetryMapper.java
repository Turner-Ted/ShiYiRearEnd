package com.shiyi.mapper;

import com.shiyi.dao.PoetryDao;

import java.util.List;

public interface PoetryMapper {

    public PoetryDao findById(String id);

    public List<PoetryDao> fingByName(String name);

    public List<PoetryDao> findByLabel(String label);

    public List<PoetryDao> findByAuthorId(String id);

    public List<PoetryDao> findByAuthorName(String name);

}
