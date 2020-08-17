package com.shiyi.service.impl;

import com.shiyi.dao.DynamicDao;
import com.shiyi.mapper.DynamicMapper;
import com.shiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class DynamicServiceImpl implements com.shiyi.service.DynamicService {

    @Autowired
    DynamicMapper mapper;

    @Autowired
    UserService userService;

    @Override
    public boolean saveDynamic(DynamicDao dynamic) {
        if (dynamic == null){
            return false;
        }

        String id;
        String userId;
        do {
            id = 1 + String.format("%05d", new Random().nextInt(99999));
            userId = mapper.selectUserIdById(id);
        }while (userId != null);

        dynamic.setId(id);
        long date = new Date().getTime();
        dynamic.setTime(date);
        mapper.save(dynamic);

        if (mapper.selectUserIdById(id) == null){
            return false;
        }
        return true;
    }

    @Override
    public List<DynamicDao> selectAllDynamic() {
        List<DynamicDao> dynamics = mapper.selectAll();
        for (DynamicDao d : dynamics){
            d.setUser(userService.selectUserAllById(d.getUserId()));
        }
        return dynamics;
    }

    @Override
    public List<DynamicDao> selectDynamicByUserId(String userId) {
        List<DynamicDao> dynamics = mapper.selectByUserId(userId);
        for (DynamicDao d : dynamics){
            d.setUser(userService.selectUserAllById(d.getUserId()));
        }
        return dynamics;
    }

    @Override
    public boolean deleteDynamicById(String id) {
        mapper.deleteById(id);
        if (mapper.selectUserIdById(id) != null){
            return false;
        }
        return true;
    }
}
