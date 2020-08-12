package com.shiyi.service.impl;

import com.shiyi.dao.UserDao;
import com.shiyi.mapper.UserMapper;
import com.shiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public boolean saveAllUser(UserDao user) {
        if (user == null){
            return false;
        }

        if (mapper.selectAllByPhone(user.getPhone()) != null){
            return false;
        }

        String id;
        boolean b;
        do {
            id = 1 + String.format("%05d", new Random().nextInt(99999));
            b = mapper.isById(id);
        }while (b);

        user.setId(id);
        mapper.saveAll(user);

        return true;

    }

    @Override
    public boolean saveUserByRegister(UserDao user) {

        if (user == null){
            return false;
        }

        if (mapper.selectAllByPhone(user.getPhone()) != null){
            return false;
        }

        String id;
        boolean b;
        do {
            id = 1 + String.format("%05d", new Random().nextInt(99999));
            b = mapper.isById(id);
        }while (b);

        user.setId(id);

        mapper.saveByRegister(user);
        return true;

    }

    @Override
    public boolean updateUserByAvatar(String avatar, String id) {
        if (avatar.equals("") || avatar.length() > 30){
            return false;
        }
        mapper.updateByAvatar(avatar, id);
        return true;
    }

    @Override
    public boolean updateUserByName(String name, String id) {
        if (name.equals("") || name.length() > 20){
            return false;
        }
        mapper.updateByName(name, id);
        return true;
    }

    @Override
    public boolean updateUserByAge(String age, String id) {
        if (age.equals("") || age.length() > 2){
            return false;
        }
        mapper.updateByAge(age, id);
        return true;
    }

    @Override
    public boolean updateUserByInfo(String info, String id) {
        if (info.equals("") || info.length() > 30)
        mapper.updateByInfo(info, id);
        return true;
    }

    @Override
    public boolean updateUserByPwd(String pwd, String id) {
        if (pwd.equals("") || pwd.length() > 20)
        mapper.updateByPwd(pwd, id);
        return true;
    }

    @Override
    public UserDao selectUserAllById(String id) {
        return mapper.selectAllById(id);
    }

    @Override
    public UserDao selectUserAllByPhone(String phone) {
        return mapper.selectAllByPhone(phone);
    }
}
