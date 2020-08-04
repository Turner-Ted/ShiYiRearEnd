package com.shiyi.mapper;

import com.shiyi.dao.AuthorDao;

import java.util.List;

public interface AuthorMapper {

    public void save(AuthorDao author);

    public List<AuthorDao> getAll();

    public Boolean isById(String id);

    public String getIdBy(String name);

    public AuthorDao getById(String id);

}
