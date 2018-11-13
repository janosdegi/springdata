package com.udemy.bharath.springdata.domain;

import javax.persistence.Embeddable;

/**
 * Created by jd on 2018.11.13..
 */
@Embeddable
public class Address {

    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    public Address() {
    }

    public Address(String streetaddress, String city, String state, String zipcode, String country) {
        this.streetaddress = streetaddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
