package com.udemy.bharath.springdata.domain;

import javax.persistence.Embeddable;

/**
 * Created by jd on 2018.11.16..
 *
 * Patient Scheduling
 *
 */
@Embeddable
public class Insurance {

    private String providerName;
    private double copay;

    public Insurance() {
    }

    public Insurance(String providerName, double copay) {
        this.providerName = providerName;
        this.copay = copay;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public double getCopay() {
        return copay;
    }

    public void setCopay(double copay) {
        this.copay = copay;
    }
}
