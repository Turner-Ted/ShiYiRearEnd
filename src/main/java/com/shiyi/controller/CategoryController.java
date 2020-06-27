package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.CategoryDao;
import com.shiyi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @RequestMapping(value = "/shows")
    public void getCategorys(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<CategoryDao> daos = service.findAllCategory();
        Gson gson = new Gson();
        String jsonCategory = gson.toJson(daos);
        System.out.println("-----------"+jsonCategory);
        response.getWriter().println(jsonCategory);
    }

}
