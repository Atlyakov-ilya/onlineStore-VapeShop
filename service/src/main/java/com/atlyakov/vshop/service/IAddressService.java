package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AddressDTO;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with model "AddressDTO" and entity "Address".
 */
public interface IAddressService {

    /**
     * Adding address in database
     *
     * @param addressDTO entity model "Address"
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void addAddress(AddressDTO addressDTO) throws ServiceException;

    /**
     * Getting address by User id
     *
     * @return AddressDTO is model for displaying information on the page
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    AddressDTO getAddressByUserId() throws ServiceException;

}
