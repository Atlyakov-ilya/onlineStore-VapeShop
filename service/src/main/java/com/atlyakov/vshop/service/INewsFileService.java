package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;

import java.io.File;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with entity "NewsFileEntity".
 */
public interface INewsFileService {

    /**
     * Receives a file from the repository by the news identifier
     *
     * @return file with location
     */
    File getNewsFileById(Integer id) throws ServiceException;

}
