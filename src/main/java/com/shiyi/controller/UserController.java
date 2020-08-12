package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.UserDao;
import com.shiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService service;

    @ResponseBody
    @RequestMapping(value = "/saveall", method = RequestMethod.POST)
    public void saveUserAll(@RequestBody UserDao user, HttpServletResponse response) throws IOException {
        if (service.saveAllUser(user)){
            response.getWriter().println("true");
        }else {
            response.getWriter().println("false");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveUserByRegister(@RequestBody UserDao user, HttpServletResponse response) throws IOException {

        if (service.saveUserByRegister(user)){
            response.getWriter().println("true");
        }else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping(value = "/update/name")
    public void updateUserByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String value = request.getParameter("value");
        if (id == null || value == null){
            return;
        }
        if (service.updateUserByName(value, id)){
            response.getWriter().println("true");
        }
    }

    @RequestMapping(value = "/update/avatar")
    public void updateUserByAvatar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String avatar = request.getParameter("value");
        if (id == null || avatar == null){
            return;
        }
        if (service.updateUserByAvatar(avatar, id)){
            response.getWriter().println("true");
        }
    }

    @RequestMapping(value = "/update/age")
    public void updateUserByAge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String age = request.getParameter("value");
        if (id == null || age == null){
            return;
        }
        if (service.updateUserByAge(age, id)){
            response.getWriter().println("true");
        }
    }

    @RequestMapping(value = "/update/info")
    public void updateUserByInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String value = request.getParameter("value");
        if (id == null || value == null){
            response.getWriter().println("false");
            return;
        }
        if (service.updateUserByInfo(value, id)){
            response.getWriter().println("true");
        }
    }

    @RequestMapping(value = "/update/pwd")
    public void updateUserByPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String value = request.getParameter("value");
        if (id == null || value == null){
            response.getWriter().println("false");
            return;
        }
        if (service.updateUserByPwd(value, id)){
            response.getWriter().println("true");
        }{
            response.getWriter().println("false");
        }
    }

    @RequestMapping(value = "seek/id")
    public void selectUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        if (id == null){
            response.getWriter().println("false");
            return;
        }
        UserDao user = service.selectUserAllById(id);
        if (user != null){
            response.getWriter().println(new Gson().toJson(user));
        }else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping(value = "seek/phone")
    public void selectUserByPhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        if (id == null){
            response.getWriter().println("false");
            return;
        }
        UserDao user = service.selectUserAllByPhone(id);
        if (user != null){
            response.getWriter().println(new Gson().toJson(user));
        }else {
            response.getWriter().println("false");
        }
    }

}
