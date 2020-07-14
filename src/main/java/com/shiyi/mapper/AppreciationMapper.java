package com.shiyi.mapper;

import com.shiyi.dao.AppreciationDao;

import java.util.List;

public interface AppreciationMapper {

    public void save(AppreciationDao appreciation);

    public List<AppreciationDao> getByPoetryId(String id);

}
