package com.atlyakov.vshop.service.util;


import com.atlyakov.vshop.entity.FeedBack;
import com.atlyakov.vshop.service.model.FeedBackDTO;

import java.util.Date;

public class FeedBackConverter {

    public static FeedBack convert(FeedBackDTO feedBackDTO) {
        FeedBack feedBack = new FeedBack();
        feedBack.setMail(feedBackDTO.getMail());
        feedBack.setTopic(feedBackDTO.getTopic());
        feedBack.setMessage(feedBackDTO.getMessage());
        feedBack.setDate(new Date());
        return feedBack;
    }

    public static FeedBackDTO convert(FeedBack feedBack) {
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setFeedBackId(feedBack.getFeedBackId());
        feedBackDTO.setUserName(feedBack.getUserName());
        feedBackDTO.setTopic(feedBack.getTopic());
        feedBackDTO.setMessage(feedBack.getMessage());
        feedBackDTO.setMail(feedBack.getMail());
        feedBackDTO.setDate(feedBack.getDate());
        return feedBackDTO;
    }

}
