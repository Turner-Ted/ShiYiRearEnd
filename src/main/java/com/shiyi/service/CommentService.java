package com.shiyi.service;

import com.shiyi.dao.CommentDao;

import java.util.List;

public interface CommentService {

    public List<CommentDao> getByPoetryIdComment(String id);

}
