package com.shiyi.mapper;

import com.shiyi.dao.VerseDao;

import java.util.List;

public interface VerseMapper {

    public VerseDao findById(String id);

    public List<VerseDao> findByPoetryId(String id);

    public List<VerseDao> findByLabel(String label);

    public List<VerseDao> findByAuthorId(String id);

    public List<VerseDao> findByAuthorName(String name);

    public List<VerseDao> findByClassic();

}
