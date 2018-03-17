package com.atlyakov.vshop.service.model;

import com.atlyakov.vshop.entity.User;
import org.hibernate.validator.constraints.NotEmpty;


import javax.validation.constraints.NotNull;

public class AddressDTO {

    private Integer addressId;
    @NotEmpty(message = "Please fill in the field street")
    private String street;
    @NotEmpty(message = "Please fill in the field house")
    private String house;
    @NotNull
    private Integer flat;
    @NotEmpty(message = "Please fill in the field city")
    private String city;
    @NotEmpty(message = "Please fill in the field region")
    private String region;
    private User user;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
