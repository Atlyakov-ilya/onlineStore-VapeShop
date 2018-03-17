package com.atlyakov.vshop.service.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class NewsDTO implements Comparable<NewsDTO> {

    private Integer newsId;
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "Content cannot be empty")
    private String content;
    private Date date;
    private MultipartFile file;
    private Integer userId;


    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId;}


    @Override
    public int compareTo(NewsDTO o) {
        if(this.newsId > o.newsId){
            return -1;
        }else if(this.newsId < o.newsId){
            return 1;
        }
        return 0;
    }

}
