package com.shiyi.dao;

//二级分类
public class TextBookDao {

    String id;
    String name;
    String imgPath;
    String typeName;

    public TextBookDao(String id, String name, String imgPath, String typeName) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.typeName = typeName;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
