package com.udemy.bharath.springdata.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by jd on 2018.11.08..
 *
 * --------------------- Inheritence mapping ---------------------
 *
 */
@Entity
//@DiscriminatorValue("ch")
//@Table(name="bankcheck") //@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="bankcheck_joined_strategy")
@PrimaryKeyJoinColumn(name="id")
public class Check extends Payment {

    private String checknumber;

    public Check() {
    }

    public Check(String checknumber) {
        this.checknumber = checknumber;
    }

    public Check(int id, double amount, String checknumber) {
        super(id, amount);
        this.checknumber = checknumber;
    }

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
