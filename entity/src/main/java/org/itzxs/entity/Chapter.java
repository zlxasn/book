package org.itzxs.entity;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable{

    private static final long serialVersionUID = -5244288298702801619L;

    private Integer id;

    private Integer bookId;

    private String bookChapterName;

    private String bookChapterContent;

    private Date modifyDate;

    public Chapter() {
    }

    public Chapter(Integer bookId, String bookChapterName, String bookChapterContent, Date modifyDate) {
        this.bookId = bookId;
        this.bookChapterName = bookChapterName;
        this.bookChapterContent = bookChapterContent;
        this.modifyDate = modifyDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", bookChapterName='" + bookChapterName + '\'' +
                ", bookChapterContent='" + bookChapterContent + '\'' +
                ", modifyDate=" + modifyDate +
                '}';
    }
}