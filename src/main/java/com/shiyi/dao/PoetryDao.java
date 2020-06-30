package com.shiyi.dao;

import java.util.ArrayList;
import java.util.List;

//诗词
public class PoetryDao {

    private String id;
    private String name;
    private String dynasty;
    private String authorName;

    private List<LabelDao> labelDaos;
    private List<VerseDao> verseDaos;
    private List<AppreciationDao> appreciationDaos;
    private List<VerseDao> classic = new ArrayList<>();

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

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<LabelDao> getLabelDaos() {
        return labelDaos;
    }

    public void setLabelDaos(List<LabelDao> labelDaos) {
        this.labelDaos = labelDaos;
    }

    public List<VerseDao> getVerseDaos() {
        return verseDaos;
    }

    public void setVerseDaos(List<VerseDao> verseDaos) {
        this.verseDaos = verseDaos;
    }

    public List<AppreciationDao> getAppreciationDaos() {
        return appreciationDaos;
    }

    public void setAppreciationDaos(List<AppreciationDao> appreciationDaos) {
        this.appreciationDaos = appreciationDaos;
    }

    public List<VerseDao> getClassic() {
        return classic;
    }

    public void setClassic(List<VerseDao> classic) {
        this.classic = classic;
    }
}
