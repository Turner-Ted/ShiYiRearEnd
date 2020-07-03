package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.CommentDao;
import com.shiyi.service.CommentService;
import com.shiyi.utils.UrlLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/comment")
public class CommentComtroller {

    @Autowired
    CommentService commentService;

    public void getComments(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html, charset=utf-8");
        List<CommentDao> daos = null;

        String poetryId = request.getParameter(UrlLabel.POETRYID);
        if (poetryId != null){
            daos = commentService.getByPoetryIdComment(poetryId);
        }

        response.getWriter().println(new Gson().toJson(daos));

    }
}
