package com.shiyi.service.impl;

import com.shiyi.dao.TextBookDao;
import com.shiyi.mapper.TextBookMapper;
import com.shiyi.service.TextBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextBookServiceImpl implements TextBookService {

    @Autowired
    TextBookMapper mapper;

    @Override
    public void saveTextBook(TextBookDao dao) {
        mapper.save(dao);
    }

    @Override
    public List<TextBookDao> findAllTextBook() {
        return mapper.findAll();
    }
}
