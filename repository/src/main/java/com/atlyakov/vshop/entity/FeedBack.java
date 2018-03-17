package com.atlyakov.vshop.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_feed_back")
public class FeedBack implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_FEED_BACK_ID")
    private Integer feedBackId;
    @Column(name = "F_USER_NAME")
    private String userName;
    @Column(name = "F_TOPIC")
    private String topic;
    @Column(name = "F_MAIL")
    private String mail;
    @Column(name = "F_MESSAGE")
    @Type(type = "text")
    private String message;
    @Column(name = "F_DATE")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "F_USER_ID", nullable = false)
    private User user;

    public Integer getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(Integer feedBackId) {
        this.feedBackId = feedBackId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

        FeedBack feedBack = (FeedBack) o;

        if (feedBackId != null ? !feedBackId.equals(feedBack.feedBackId) : feedBack.feedBackId != null) return false;
        if (userName != null ? !userName.equals(feedBack.userName) : feedBack.userName != null) return false;
        if (topic != null ? !topic.equals(feedBack.topic) : feedBack.topic != null) return false;
        if (mail != null ? !mail.equals(feedBack.mail) : feedBack.mail != null) return false;
        return message != null ? message.equals(feedBack.message) : feedBack.message == null;
    }

    @Override
    public int hashCode() {
        int result = feedBackId != null ? feedBackId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeedBack{");
        sb.append("feedBackId=").append(feedBackId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", topic='").append(topic).append('\'');
        sb.append(", mail='").append(mail).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
