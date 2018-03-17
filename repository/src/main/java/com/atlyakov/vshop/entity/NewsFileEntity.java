package com.atlyakov.vshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "t_news_file")
public class NewsFileEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_NEWS_ID", nullable = false)
    private Integer newsId;
    @Column(name = "F_FILE_NAME")
    private String fileName;
    @Column(name = "F_LOCATION")
    private String location;
    @OneToOne
    @PrimaryKeyJoinColumn
    private News news;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsFileEntity that = (NewsFileEntity) o;

        if (!newsId.equals(that.newsId)) return false;
        if (!fileName.equals(that.fileName)) return false;
        return location.equals(that.location);
    }

    @Override
    public int hashCode() {
        int result = newsId.hashCode();
        result = 31 * result + fileName.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
}
