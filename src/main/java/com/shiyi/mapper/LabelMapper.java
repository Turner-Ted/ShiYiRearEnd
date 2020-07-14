package com.shiyi.mapper;

import java.util.List;

public interface LabelMapper {

    public void saveByPoetry(String name, String id);

    public List<String> findLabelByName(String name);

    public List<String> findLabelById(String id);

}
