package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.PoetryDao;
import com.shiyi.service.PoetryService;
import com.shiyi.service.VerseService;
import com.shiyi.utils.UrlLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

        String id = request.getParameter(UrlLabel.ID);
        String name = request.getParameter(UrlLabel.NAME);
        String label = request.getParameter(UrlLabel.LABEL);
        String authorId = request.getParameter(UrlLabel.AUTHORID);
        String authorName = request.getParameter(UrlLabel.AUTHORNAME);

        if (id != null){
            dao = poetryService.findByIdPoetry(id);
//            poetryService.savePoetry(dao);
            id = null;
        }else if (name != null){
            daos = poetryService.fingByNamePoetry(name);
            name = null;
        }else if (label != null){
            daos = poetryService.findByLabelPoetry(label);
            label = null;
        }else if (authorId != null){
            daos = poetryService.findByAuthorIdPoetry(authorId);
            authorId = null;
        }else if (authorName != null){
            daos = poetryService.findByAuthorNamePoetry(authorName);
            authorName = null;
        }else {

        }

        if (dao != null){
            System.out.println("返回数据："+dao.toString());
            response.getWriter().println(new Gson().toJson(dao));
        } else if (daos != null){
            System.out.println("返回数据："+daos.toString());
            response.getWriter().println(new Gson().toJson(daos));
        }

    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void savePoetry(@RequestBody PoetryDao poetry, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("post:" + poetry.toString());
        poetryService.savePoetry(poetry);

        response.getWriter().println("true");
    }

}