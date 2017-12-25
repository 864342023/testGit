package com.sxt.bls.pojo;

import java.util.Date;

public class Book {

    private Integer bookid;//id
    private String bookCode;//图书编号
    private String bookName;//图书名称
    private String bookType;//图书类型
    private String author;//图书作者
    private String publishPress;//图书出版社
    private Date publishDate;//图书出版日期
    private Integer isBorrow;//图书是否借阅
    private String createdBy;//创建人
    private Date creationTime;//创建时间
    private Date lastUpdateTime;//最新更新时间

    public Book(Integer bookid, String bookCode, String bookName, String bookType, String author, String publishPress, Date publishDate, Integer isBorrow, String createdBy, Date creationTime, Date lastUpdateTime) {
        this.bookid = bookid;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookType = bookType;
        this.author = author;
        this.publishPress = publishPress;
        this.publishDate = publishDate;
        this.isBorrow = isBorrow;
        this.createdBy = createdBy;
        this.creationTime = creationTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Book() {
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishPress() {
        return publishPress;
    }

    public void setPublishPress(String publishPress) {
        this.publishPress = publishPress;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(Integer isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookCode='" + bookCode + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookType='" + bookType + '\'' +
                ", author='" + author + '\'' +
                ", publishPress='" + publishPress + '\'' +
                ", publishDate=" + publishDate +
                ", isBorrow=" + isBorrow +
                ", createdBy='" + createdBy + '\'' +
                ", creationTime=" + creationTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
