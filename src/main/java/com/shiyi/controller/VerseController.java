package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.VerseDao;
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
@RequestMapping(value = "/verse")
public class VerseController {

    @Autowired
    VerseService verseService;

    @RequestMapping(value = "/shows")
    public void getVerseAll(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
    }

    @RequestMapping(value = "/seek")
    public void getVerse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        VerseDao dao = null;
        List<VerseDao> daos = null;

        String id = request.getParameter(UrlLabel.ID);
        String poetryId = request.getParameter(UrlLabel.POETRYID);
        String label = request.getParameter(UrlLabel.LABEL);
        String authorId = request.getParameter(UrlLabel.AUTHORID);
        String authorName = request.getParameter(UrlLabel.AUTHORNAME);

        if (id != null){
            dao = verseService.findByIdVerse(id);
            id = null;
        } else if (poetryId != null){
            daos = verseService.findByPoetryIdVerse(poetryId);
            poetryId = null;
        } else if (label != null){
            daos = verseService.findByLabelVerse(label);
            label = null;
        } else if (authorId != null){
            daos = verseService.findByAuthorIdVerse(authorId);
            authorId = null;
        } else if (authorName != null){
            daos = verseService.findByAuthorNameVerse(authorName);
            authorName = null;
        } else {

        }

        if (dao != null){
            System.out.println("-----------"+dao.toString());
            response.getWriter().println(new Gson().toJson(dao));
        } else if (daos != null){
            System.out.println("-----------"+daos.toString());
            response.getWriter().println(new Gson().toJson(daos));
        }


    }

    @RequestMapping(value = "classic")
    public void getClassicVerse(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<VerseDao> daos = verseService.findByClassicVerse();
        if (daos != null){
            String jsonString = new Gson().toJson(daos);
            System.out.println("-----------"+jsonString);
            response.getWriter().println(jsonString);
        }
    }
}
