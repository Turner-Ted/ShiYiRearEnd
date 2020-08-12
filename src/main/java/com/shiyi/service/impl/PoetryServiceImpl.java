package com.shiyi.service.impl;

import com.shiyi.dao.AppreciationDao;
import com.shiyi.dao.PoetryDao;
import com.shiyi.dao.VerseDao;
import com.shiyi.mapper.*;
import com.shiyi.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    @Autowired
    VerseServiceImpl verseService;

    @Autowired
    DynastyMapper dynastyMapper;

    @Autowired
    LabelMapper labelMapper;

    @Override
    public void savePoetry(PoetryDao poetry) {

        if (poetry == null || mapper.isPoetry(poetry.getName(), poetry.getDynasty()) != null){
            return;
        }

//        System.out.println(poetry.toString());

        String id;
        Boolean idFlag;
        String aId = authorMapper.getIdBy(poetry.getAuthorName());
        System.out.println("aId:" + aId);
        String dId = dynastyMapper.getIdByName(poetry.getDynasty());
        System.out.println("dId:" + dId);
        if (dId == null){
            dId = "9";
        }
//        System.out.println("dId:" + dId);
        int count = 0;
        int t = 4;
        do {
            count++;
            if (count >= 50){
                t++;
            }
            if (t > 9){
                return;
            }
            id = t + dId + String.format("%03d", new Random().nextInt(999));
            idFlag = mapper.isById(id);
            System.out.println("idFlag:" + idFlag);
        }while (idFlag != null);

//        System.out.println("id:" + id);
        if (aId == null){
            do {
                aId = dId + String.format("%02d", new Random().nextInt(99));
                idFlag = authorMapper.isById(aId);
            }while (idFlag != null);
            poetry.getAuthor().setId(aId);
            authorMapper.save(poetry.getAuthor());
        }
//        System.out.println("aId:" + aId);

        poetry.setId(id);
        poetry.setAuthorId(aId);
        poetry.getAuthor().setId(aId);

        mapper.save(poetry);

        if (poetry.getVerses()!=null){
            for (VerseDao v:poetry.getVerses()){
                v.setAuthorId(aId);
                v.setPoetryId(id);
                v.setId(id+v.getSeries());
                v.setAuthorName(poetry.getAuthorName());
//                System.out.println("v:" + v.toString());
                verseService.save(v);
            }
        }

//        System.out.println("p:" + poetry.toString());

        if (poetry.getAppreciations()!=null){
            for (AppreciationDao a : poetry.getAppreciations()){
                a.setPoetryId(id);
            System.out.println("a:" + a.toString());
                appreciationMapper.save(a);
            }
        }

        if (poetry.getLabels()!=null){
            for (String l : poetry.getLabels()){
           System.out.println("l:" + l);
                labelMapper.saveByPoetry(l, poetry.getId());
            }
        }

    }

    @Override
    public List<PoetryDao> findAllPoetry() {
        List<PoetryDao> poetrys;
        poetrys = mapper.findAll();
        getFristVerse(poetrys);
        return poetrys;
    }

    @Override
    public Boolean isByIdPoetry(String id) {
        return mapper.isById(id);
    }

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
            poetry.setLabels(labelMapper.findLabelById(id));

        }
        return poetry;
    }

    @Override
    public List<PoetryDao> fingByNamePoetry(String name) {
        List<PoetryDao> poetrys;
        poetrys = mapper.findByName(name);
        getFristVerse(poetrys);
        return poetrys;
    }

    @Override
    public List<PoetryDao> findByLabelPoetry(String label) {
        List<PoetryDao> poetrys;
        poetrys = mapper.findByLabel("%"+label+"%");
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
                String verse = " ";
                if (verseMapper.findById(p.getId()+"00") != null){
                    verse = verseMapper.findById(p.getId()+"00").getText();
                }
                p.setVerse(verse);
            }
        }
    }
}
