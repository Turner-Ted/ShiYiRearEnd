package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.CategoryDao;
import com.shiyi.service.CategoryService;
import com.shiyi.service.TextBookService;
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

    @Autowired
    TextBookService textBookService;

    @RequestMapping(value = "/shows")
    public void getCategorys(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<CategoryDao> daos = service.findAllCategory();
        for (CategoryDao dao : daos){
            dao.setList(textBookService.findByTypeTextBook(dao.getName()));
        }
        for (int i = daos.size() - 1; i >= 0; --i) {
            if (daos.get(i).getList().size() == 0){
                daos.remove(i);
            }

        }
        Gson gson = new Gson();
        String jsonCategory = gson.toJson(daos);
        System.out.println("-----------"+jsonCategory);
        response.getWriter().println(jsonCategory);
    }
}
