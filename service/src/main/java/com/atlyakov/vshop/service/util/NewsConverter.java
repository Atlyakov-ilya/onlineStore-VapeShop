package com.atlyakov.vshop.service.util;

import com.atlyakov.vshop.entity.News;
import com.atlyakov.vshop.service.model.NewsDTO;

import java.util.Date;

public class NewsConverter {

    public static News converter(NewsDTO newsDTO) {
        News news = new News();
        news.setNewsId(newsDTO.getNewsId());
        news.setTitle(newsDTO.getTitle());
        news.setContent(newsDTO.getContent());
        news.setDate(new Date());
        return news;
    }

    public static NewsDTO converter(News news) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setNewsId(news.getNewsId());
        newsDTO.setTitle(news.getTitle());
        newsDTO.setContent(news.getContent());
        newsDTO.setDate(news.getDate());
        return newsDTO;
    }

}
