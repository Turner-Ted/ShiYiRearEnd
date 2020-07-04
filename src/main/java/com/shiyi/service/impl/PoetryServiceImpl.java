package com.shiyi.service.impl;

import com.shiyi.dao.PoetryDao;
import com.shiyi.mapper.*;
import com.shiyi.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryServiceImpl implements PoetryService {

    @Autowired
    PoetryMapper mapper;

    @Autowired
    VerseMapper verseMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    AppreciationMapper appreciationMapper;

    @Autowired
    AuthorMapper authorMapper;

    @Override
    public PoetryDao findByIdPoetry(String id) {
        PoetryDao poetry;
        poetry = mapper.findById(id);
        if (poetry!=null){
            poetry.setVerses(verseMapper.findByPoetryId(id));
            poetry.setAuthor(authorMapper.getById(poetry.getAuthorId()));
            poetry.setClassics(verseMapper.findClassicByPoetryId(id));
            poetry.setComments(commentMapper.getByPoetryId(id));
            poetry.setAppreciations(appreciationMapper.getByPoetryId(id));
        }
        return poetry;
    }

    @Override
    public List<PoetryDao> fingByNamePoetry(String name) {
        List<PoetryDao> poetrys;
        poetrys = mapper.fingByName(name);
        getFristVerse(poetrys);
        return poetrys;
    }

    @Override
    public List<PoetryDao> findByLabelPoetry(String label) {
        List<PoetryDao> poetrys;
        poetrys = mapper.findByLabel(label);
        getFristVerse(poetrys);
        return poetrys;
    }

    @Override
    public List<PoetryDao> findByAuthorIdPoetry(String id) {
        List<PoetryDao> poetrys;
        poetrys = mapper.findByAuthorId(id);
        getFristVerse(poetrys);
        return poetrys;
    }

    @Override
    public List<PoetryDao> findByAuthorNamePoetry(String name) {
        List<PoetryDao> poetrys;
        poetrys = mapper.findByAuthorName(name);
        getFristVerse(poetrys);
        return poetrys;
    }

    private void getFristVerse(List<PoetryDao> poetrys){
        if (poetrys!=null){
            for (PoetryDao p:poetrys){
                p.setVerse(verseMapper.findById(p.getId()+"00").getText());
            }
        }
    }
}
