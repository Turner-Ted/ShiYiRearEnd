package com.shiyi.mapper;

import com.shiyi.dao.UserDao;

public interface UserMapper {

    public void saveAll(UserDao user);

    public void saveByRegister(UserDao user);

    public void updateByAvatar(String avatar, String id);

    public void updateByName(String name, String id);

    public void updateByAge(String age, String id);

    public void updateByInfo(String info, String id);

    public void updateByPwd(String pwd, String id);

    public UserDao selectAllById(String id);

    public UserDao selectAllByPhone(String phone);

    public boolean isById(String id);

}
