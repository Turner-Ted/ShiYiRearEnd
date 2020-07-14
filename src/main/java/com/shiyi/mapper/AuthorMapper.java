package com.shiyi.mapper;

import com.shiyi.dao.AuthorDao;

public interface AuthorMapper {

    public void save(AuthorDao author);

    public Boolean isById(String id);

    public String getIdBy(String name, String dynasty);

    public AuthorDao getById(String id);

}
