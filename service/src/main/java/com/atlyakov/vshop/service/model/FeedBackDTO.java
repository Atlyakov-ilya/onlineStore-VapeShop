package com.atlyakov.vshop.service.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

public class FeedBackDTO {
    private Integer feedBackId;
    private String userName;
    @NotEmpty(message = "Topic cannot be empty")
    @Size(min=3, max = 30 , message = "Topic should be between 3 and 30 characters long")
    private String topic;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Incorrect email. Please try again")
    private String mail;
    @NotEmpty(message = "Please write the message")
    private String message;
    private Date date;

    public Integer getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(Integer feedBackId) {
        this.feedBackId = feedBackId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
