package org.itzxs.entity;

public class Chapter {
    private Integer id;

    private int bookId;

    private String bookChapterName;

    private String bookChapterContent;

    public Chapter() {
    }

    public Chapter(int bookId, String bookChapterName, String bookChapterContent) {
        this.bookId = bookId;
        this.bookChapterName = bookChapterName;
        this.bookChapterContent = bookChapterContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookChapterName() {
        return bookChapterName;
    }

    public void setBookChapterName(String bookChapterName) {
        this.bookChapterName = bookChapterName == null ? null : bookChapterName.trim();
    }

    public String getBookChapterContent() {
        return bookChapterContent;
    }

    public void setBookChapterContent(String bookChapterContent) {
        this.bookChapterContent = bookChapterContent == null ? null : bookChapterContent.trim();
    }
}