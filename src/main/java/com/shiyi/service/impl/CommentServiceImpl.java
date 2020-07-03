package com.shiyi.service.impl;

import com.shiyi.dao.CommentDao;
import com.shiyi.mapper.CommentMapper;
import com.shiyi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper mapper;

    @Override
    public List<CommentDao> getByPoetryIdComment(String id) {
        return mapper.getByPoetryId(id);
    }
}
