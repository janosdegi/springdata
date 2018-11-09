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
//@DiscriminatorValue("cc")
//@Table(name="card") //@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="card_joined_strategy")
@PrimaryKeyJoinColumn(name="id")
public class CreditCard extends Payment {

    private String cardnumber;

    public CreditCard() {
    }

    public CreditCard(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public CreditCard(int id, double amount, String cardnumber) {
        super(id, amount);
        this.cardnumber = cardnumber;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
