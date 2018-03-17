package com.atlyakov.vshop.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_NEWS_ID")
    private Integer newsId;
    @Column(name = "F_TITLE")
    private String title;
    @Column(name = "F_CONTENT")
    @Type(type = "text")
    private String content;
    @Column(name = "F_DATE")
    @Temporal(value = TemporalType.DATE)
    private Date date;
    @OneToOne(mappedBy = "news", cascade = CascadeType.ALL)
    private NewsFileEntity newsFileEntity;
    @ManyToOne
    @JoinColumn(name = "F_USER_ID", nullable = false)
    private User user;

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

    public NewsFileEntity getNewsFileEntity() {
        return newsFileEntity;
    }

    public void setNewsFileEntity(NewsFileEntity newsFileEntity) {
        this.newsFileEntity = newsFileEntity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (!newsId.equals(news.newsId)) return false;
        if (!title.equals(news.title)) return false;
        if (!content.equals(news.content)) return false;
        return date.equals(news.date);
    }

    @Override
    public int hashCode() {
        int result = newsId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
