package com.shiyi.service.impl;

import com.shiyi.dao.AuthorDao;
import com.shiyi.mapper.AuthorMapper;
import com.shiyi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorMapper mapper;

    @Override
    public void saveAuthor(AuthorDao author) {
        mapper.save(author);
    }

    @Override
    public List<AuthorDao> getAuthorAll() {
        return mapper.getAll();
    }

    @Override
    public Boolean isAuthorById(String id) {
        return mapper.isById(id);
    }

    @Override
    public String getAuthorIdBy(String name) {
        return mapper.getIdBy(name);
    }

    @Override
    public AuthorDao getAuthorById(String id) {
        return mapper.getById(id);
    }
}
