package com.shiyi.mapper;

import com.shiyi.dao.PoetryDao;

import java.util.List;

public interface PoetryMapper {

    public void save(PoetryDao poetry);

    public List<PoetryDao> findAll();

    public Boolean isById(String id);

    public Boolean isPoetry(String name, String dynasty);

    public PoetryDao findById(String id);

    public List<PoetryDao> findByName(String name);

    public List<PoetryDao> findByLabel(String label);

    public List<PoetryDao> findByAuthorId(String id);

    public List<PoetryDao> findByAuthorName(String name);

}
