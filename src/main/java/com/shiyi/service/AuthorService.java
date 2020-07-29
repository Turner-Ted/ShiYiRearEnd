package com.shiyi.service;

import com.shiyi.dao.AuthorDao;

import java.util.List;

public interface AuthorService {

    public void saveAuthor(AuthorDao author);

    public List<AuthorDao> getAuthorAll();

    public Boolean isAuthorById(String id);

    public String getAuthorIdBy(String name, String dynasty);

    public AuthorDao getAuthorById(String id);

}
