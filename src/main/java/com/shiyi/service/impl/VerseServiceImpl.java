package com.shiyi.service.impl;

import com.shiyi.dao.CommentDao;
import com.shiyi.dao.VerseDao;
import com.shiyi.mapper.CommentMapper;
import com.shiyi.mapper.VerseMapper;
import com.shiyi.service.VerseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerseServiceImpl implements VerseService {

    @Autowired
    VerseMapper mapper;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public void save(VerseDao verse) {
        if (verse == null){
            return;
        }
        mapper.save(verse);
        if (verse.getComments() == null){
            return;
        }
        for (CommentDao c : verse.getComments()){
            c.setVerseId(verse.getId());
            commentMapper.save(c);
        }
    }

    @Override
    public List<VerseDao> findAllVerse() {
        return mapper.findAll();
    }

    @Override
    public VerseDao findByIdVerse(String id) {
        return mapper.findById(id);
    }

    @Override
    public List<VerseDao> findByPoetryIdVerse(String id) {
        return mapper.findByPoetryId(id);
    }

    @Override
    public List<VerseDao> findByLabelVerse(String label) {
        return mapper.findByLabel(label);
    }

    @Override
    public List<VerseDao> findByAuthorIdVerse(String id) {
        return mapper.findByAuthorId(id);
    }

    @Override
    public List<VerseDao> findByAuthorNameVerse(String name) {
        return mapper.findByAuthorName(name);
    }

    @Override
    public List<VerseDao> findByClassicVerse() {
        return mapper.findClassic();
    }

    @Override
    public List<VerseDao> findClassicByPoetryIdVerse(String id) {
        return mapper.findClassicByPoetryId(id);
    }
}
