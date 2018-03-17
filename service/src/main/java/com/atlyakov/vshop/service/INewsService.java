package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.NewsDTO;

import java.util.List;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with model "NewsDTO" and entity "News".
 */
public interface INewsService {

    void saveNews(NewsDTO newsDTO) throws ServiceException;

    List <NewsDTO> getAll() throws ServiceException;

    NewsDTO getNewsById(Integer newsId) throws ServiceException;

    void removeNews(Integer newsId) throws ServiceException;

    void editNews(NewsDTO newsDTO) throws ServiceException;
}
