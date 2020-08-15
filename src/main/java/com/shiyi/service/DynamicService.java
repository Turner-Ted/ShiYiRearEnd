package com.shiyi.service;

import com.shiyi.dao.DynamicDao;

import java.util.List;

public interface DynamicService {

    public boolean saveDynamic(DynamicDao dynamic);

    public List<DynamicDao> selectAllDynamic();

    public List<DynamicDao> selectDynamicByUserId(String userId);

    public boolean deleteDynamicById(String id);

}
