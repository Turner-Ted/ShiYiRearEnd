package com.shiyi.dao;

import java.util.List;

//诗句
public class VerseDao {

    private String id;
    private String series;
    private String poetryId;
    private String authorId;
    private String authorName;
    private String text;
    private String translation;
    private boolean classic;

    private List<LabelDao> labelDaos;
    private List<CommentDao> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(String poetryId) {
        this.poetryId = poetryId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public List<LabelDao> getLabelDaos() {
        return labelDaos;
    }

    public void setLabelDaos(List<LabelDao> labelDaos) {
        this.labelDaos = labelDaos;
    }

    public boolean isClassic() {
        return classic;
    }

    public void setClassic(boolean classic) {
        this.classic = classic;
    }

    public List<CommentDao> getComments() {
        return comments;
    }

    public void setComments(List<CommentDao> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "VerseDao{" +
                "id='" + id + '\'' +
                ", series='" + series + '\'' +
                ", poetryId='" + poetryId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", text='" + text + '\'' +
                ", translation='" + translation + '\'' +
                ", classic=" + classic +
                ", labelDaos=" + labelDaos +
                ", comments=" + comments +
                '}';
    }
}
