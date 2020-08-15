package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.DynamicDao;
import com.shiyi.service.DynamicService;
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
@RequestMapping(value = "/dynamic")
public class DynamicController {

    @Autowired
    DynamicService service;

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save(@RequestBody DynamicDao dynamic, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if (service.saveDynamic(dynamic)){
            response.getWriter().println("true");
        }else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping(value = "show")
    public void getDynamicAll(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<DynamicDao> dynamics = service.selectAllDynamic();
        response.getWriter().println(new Gson().toJson(dynamics));
    }

    @RequestMapping(value = "delete")
    public void deleteDynamicById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        if (id == null){
            response.getWriter().println("false");
            return;
        }

        if (service.deleteDynamicById(id)){
            response.getWriter().println("true");
        }else {
            response.getWriter().println("false");
        }
    }

}
