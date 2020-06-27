package com.shiyi.dao;

import java.util.List;

public class CategoryDao {

    String id;
    String name;
    List<TextBookDao> list;

    public CategoryDao(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TextBookDao> getList() {
        return list;
    }

    public void setList(List<TextBookDao> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CategoryDao{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
