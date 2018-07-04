package org.itzxs.entity;

import java.io.Serializable;
import java.util.Date;

public class QidianBook implements Serializable{

    private static final long serialVersionUID = -5244288298702801619L;

    private Integer id;

    private String bookName;

    private String bookUrl;

    private Integer bookLevel;

    private String bookImgUrl;

    private String bookAuthor;

    private Date modifyDate;

    private Integer bookType;

    private String bookDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl == null ? null : bookUrl.trim();
    }

    public Integer getBookLevel() {
        return bookLevel;
    }

    public void setBookLevel(Integer bookLevel) {
        this.bookLevel = bookLevel;
    }

    public String getBookImgUrl() {
        return bookImgUrl;
    }

    public void setBookImgUrl(String bookImgUrl) {
        this.bookImgUrl = bookImgUrl == null ? null : bookImgUrl.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public String getBookDescribe() {
        return bookDescribe;
    }

    public void setBookDescribe(String bookDescribe) {
        this.bookDescribe = bookDescribe == null ? null : bookDescribe.trim();
    }

    @Override
    public String toString() {
        return "QidianBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookUrl='" + bookUrl + '\'' +
                ", bookLevel=" + bookLevel +
                ", bookImgUrl='" + bookImgUrl + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", modifyDate=" + modifyDate +
                ", bookType=" + bookType +
                ", bookDescribe='" + bookDescribe + '\'' +
                '}';
    }
}