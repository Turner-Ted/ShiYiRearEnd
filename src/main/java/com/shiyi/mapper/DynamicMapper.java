package com.shiyi.mapper;

import com.shiyi.dao.DynamicDao;

import java.util.List;

public interface DynamicMapper {

    public void save(DynamicDao dynamic);

    public List<DynamicDao> selectAll();

    public List<DynamicDao> selectByUserId(String userId);

    public void deleteById(String id);

    public String selectUserIdById(String id);

}
