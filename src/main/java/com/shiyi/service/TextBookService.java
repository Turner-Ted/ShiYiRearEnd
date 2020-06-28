package com.shiyi.service;

import com.shiyi.dao.TextBookDao;

import java.util.List;

public interface TextBookService {

    public void saveTextBook(TextBookDao dao);

    public List<TextBookDao> findAllTextBook();

    public List<TextBookDao> findByTypeTextBook(String type);

}
