package com.shiyi.dao;

import java.util.ArrayList;
import java.util.List;

//诗词
public class PoetryDao {

    private String id;
    private String name;
    private String dynasty;
    private String authorId;
    private String authorName;
    private String verse;
    private AuthorDao author;

    private List<String> labels;
    private List<VerseDao> verses;
    private List<AppreciationDao> appreciations;
    private List<VerseDao> classics = new ArrayList<>();
    private List<CommentDao> comments;

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

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public AuthorDao getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDao author) {
        this.author = author;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<VerseDao> getVerses() {
        return verses;
    }

    public void setVerses(List<VerseDao> verses) {
        this.verses = verses;
    }

    public List<AppreciationDao> getAppreciations() {
        return appreciations;
    }

    public void setAppreciations(List<AppreciationDao> appreciations) {
        this.appreciations = appreciations;
    }

    public List<VerseDao> getClassics() {
        return classics;
    }

    public void setClassics(List<VerseDao> classics) {
        this.classics = classics;
    }

    public List<CommentDao> getComments() {
        return comments;
    }

    public void setComments(List<CommentDao> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PoetryDao{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", verse='" + verse + '\'' +
                ", author=" + author +
                ", labels=" + labels +
                ", verses=" + verses +
                ", appreciations=" + appreciations +
                ", classics=" + classics +
                ", comments=" + comments +
                '}';
    }
}
