package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.PoetryDao;
import com.shiyi.dao.VerseDao;
import com.shiyi.service.PoetryService;
import com.shiyi.service.VerseService;
import com.shiyi.utils.UrlLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/poetry")
public class PoetryController {

    @Autowired
    PoetryService poetryService;

    @Autowired
    VerseService verseService;

    @RequestMapping("/seek")
    public void getPoetry(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PoetryDao dao = null;
        List<PoetryDao> daos = null;
        String jsonString = null;

        String id = request.getParameter(UrlLabel.ID);
        String name = request.getParameter(UrlLabel.NAME);
        String label = request.getParameter(UrlLabel.LABEL);
        String authorId = request.getParameter(UrlLabel.AUTHORID);
        String authorName = request.getParameter(UrlLabel.AUTHORNAME);

        if (id != null){
            dao = poetryService.findByIdPoetry(id);
            if (dao != null){
                dao.setVerses(verseService.findByPoetryIdVerse(dao.getId()));
                for (VerseDao v : dao.getVerses()){
                    if (v.isClassic()){
                        dao.getClassics().add(v);
                    }
                }
            }
        }else if (name != null){
            daos = poetryService.fingByNamePoetry(name);
        }else if (label != null){
            daos = poetryService.findByLabelPoetry(label);
            if (daos != null){
                for (PoetryDao d : daos){
                    VerseDao verseDao = verseService.findByIdVerse(d.getId()+"00");
                    if (verseDao != null){
                        d.setVerse(verseDao.getText());
                    }

                }
            }
        }else if (authorId != null){
            daos = poetryService.findByAuthorIdPoetry(authorId);
        }else if (authorName != null){
            daos = poetryService.findByAuthorNamePoetry(authorName);
        }else {

        }

        if (dao != null){
            jsonString = new Gson().toJson(dao);
        } else if (daos != null){
            jsonString = new Gson().toJson(daos);
        }

        System.out.println("-----------"+jsonString);
        response.getWriter().println(jsonString);

    }

}
