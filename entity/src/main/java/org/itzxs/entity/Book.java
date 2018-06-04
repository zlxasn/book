package org.itzxs.entity;

import java.util.Date;

public class Book {
    private Integer id;

    private String bookName;

    private String bookUrl;

    private Integer bookLevel;

    private String bookImgUrl;

    private String bookUser;

    private Date modifyDate;

    private Integer bookType;

    private String bookDescribe;

    public Book() {
    }

    public Book(String bookName, String bookUrl, Integer bookLevel, String bookImgUrl, String bookUser, Date modifyDate, Integer bookType, String bookDescribe) {
        this.bookName = bookName;
        this.bookUrl = bookUrl;
        this.bookLevel = bookLevel;
        this.bookImgUrl = bookImgUrl;
        this.bookUser = bookUser;
        this.modifyDate = modifyDate;
        this.bookType = bookType;
        this.bookDescribe = bookDescribe;
    }

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

    public String getBookUser() {
        return bookUser;
    }

    public void setBookUser(String bookUser) {
        this.bookUser = bookUser == null ? null : bookUser.trim();
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
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookUrl='" + bookUrl + '\'' +
                ", bookLevel=" + bookLevel +
                ", bookImgUrl='" + bookImgUrl + '\'' +
                ", bookUser='" + bookUser + '\'' +
                ", modifyDate=" + modifyDate +
                ", bookType=" + bookType +
                ", bookDescribe='" + bookDescribe + '\'' +
                '}';
    }
}