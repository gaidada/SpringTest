package com.gai.bean;

public class Book {
    private String bookName;
    private String authorName;

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void myInit() {
        System.out.println("初始化方法");
    }

    public void myDestry() {
        System.out.println("销毁方法");
    }
}
