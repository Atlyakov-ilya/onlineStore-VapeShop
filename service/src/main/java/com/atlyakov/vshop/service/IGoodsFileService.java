package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;

import java.io.File;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with entity "GoodsFileEntity".
 */
public interface IGoodsFileService {

    /**
     * Receives a file from the repository by the goods identifier
     *
     * @return file with location
     */
    File getGoodsFileById(Integer goodsId);
}
