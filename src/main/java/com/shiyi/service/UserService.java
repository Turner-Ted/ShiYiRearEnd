package com.shiyi.service;

import com.shiyi.dao.UserDao;

public interface UserService {

    public boolean saveAllUser(UserDao user);

    public boolean saveUserByRegister(UserDao user);

    public boolean updateUserByAvatar(String avatar, String id);

    public boolean updateUserByName(String name, String id);

    public boolean updateUserByAge(String age, String id);

    public boolean updateUserByInfo(String info, String id);

    public boolean updateUserByPwd(String pwd, String id);

    public UserDao selectUserAllById(String id);

    public UserDao selectUserAllByPhone(String phone);

}
