package com.shiyi.dao;

//注释
public class CommentDao {

    private String series;
    private String verseId;
    private String field;
    private String text;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getVerseId() {
        return verseId;
    }

    public void setVerseId(String verseId) {
        this.verseId = verseId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
