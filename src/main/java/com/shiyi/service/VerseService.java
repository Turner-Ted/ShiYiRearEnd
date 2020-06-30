package com.shiyi.service;

import com.shiyi.dao.VerseDao;

import java.util.List;

public interface VerseService {

    public VerseDao findByIdVerse(String id);

    public List<VerseDao> findByPoetryIdVerse(String id);

    public List<VerseDao> findByLabelVerse(String label);

    public List<VerseDao> findByAuthorIdVerse(String id);

    public List<VerseDao> findByAuthorNameVerse(String name);

    public List<VerseDao> findByClassicVerse();

}
