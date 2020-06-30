package com.shiyi.service.impl;

import com.shiyi.dao.PoetryDao;
import com.shiyi.mapper.PoetryMapper;
import com.shiyi.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryServiceImpl implements PoetryService {

    @Autowired
    PoetryMapper mapper;

    @Override
    public PoetryDao findByIdPoetry(String id) {
        return mapper.findById(id);
    }

    @Override
    public List<PoetryDao> fingByNamePoetry(String name) {
        return mapper.fingByName(name);
    }

    @Override
    public List<PoetryDao> findByLabelPoetry(String label) {
        return mapper.findByLabel(label);
    }

    @Override
    public List<PoetryDao> findByAuthorIdPoetry(String id) {
        return mapper.findByAuthorId(id);
    }

    @Override
    public List<PoetryDao> findByAuthorNamePoetry(String name) {
        return mapper.findByAuthorName(name);
    }
}
