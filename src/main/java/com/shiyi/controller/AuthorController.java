package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    AuthorService service;

    @RequestMapping(value = "/shows")
    public void getAuthorAll(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(new Gson().toJson(service.getAuthorAll()));
    }

}
