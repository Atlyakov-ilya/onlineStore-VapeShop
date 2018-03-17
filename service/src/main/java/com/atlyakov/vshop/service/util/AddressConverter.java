package com.atlyakov.vshop.service.util;

import com.atlyakov.vshop.entity.Address;
import com.atlyakov.vshop.service.model.AddressDTO;

public class AddressConverter {

    public static Address convert(AddressDTO addressDTO) {
        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setFlat(addressDTO.getFlat());
        address.setHouse(addressDTO.getHouse());
        address.setRegion(addressDTO.getRegion());
        address.setStreet(addressDTO.getStreet());
        return address;
    }

    public static AddressDTO convert(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(address.getCity());
        addressDTO.setFlat(address.getFlat());
        addressDTO.setHouse(address.getHouse());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setRegion(address.getRegion());
        return addressDTO;
    }
}
