package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.UserDao;
import com.shiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

        System.out.println(new Gson().toJson(user));
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

    @RequestMapping(value = "/update/avatar", method = RequestMethod.POST)
    public void updateUserByAvatar(@RequestParam("avatar") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        String filePath = "/img/user";// 保存图片的路径
        // String filePath = "/image";//保存图片的路径
        // 获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename: " + originalFilename);
        // 新的文件名字
        String newFileName = UUID.randomUUID() + originalFilename;
        // 封装上传文件位置的全路径
        filePath += "/" + id;
        System.out.println("filePath: " + filePath);
        File targetFile = new File(filePath, newFileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 把本地文件上传到封装上传文件位置的全路径
        System.out.println("newFileName: " + newFileName);

        System.out.println("targetFile: " + targetFile.getName());
        System.out.println("id: " + id);
        //System.out.println("afterPhone");
        try {
            file.transferTo(targetFile);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String allPath=filePath + "/" + id+ "/" + newFileName;
        System.out.println("存储路径为"+allPath);
        boolean result=service.updateUserByAvatar(allPath, id);//存在数据库中，其中allPath的数据库类型为varchar(1000)
        if (result){

        }else {
            response.getWriter().println("false");
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
