package com.udemy.bharath.springdata.domain;

import javax.persistence.*;

/**
 * Created by jd on 2018.11.08..
 *
 * --------------------- Inheritence mapping ---------------------
 *
 * CREATE TABLE payment
     (
     id INTEGER PRIMARY KEY NOT NULL,
     pmode VARCHAR(2),
     amount NUMERIC(8,3),
     cardnumber VARCHAR(20),
     checknumber VARCHAR(20)
     );
 *
 *
 *
 *
 *
 *
 * create table public.payment_joined_strategy(
     id INTEGER PRIMARY KEY NOT NULL,
     amount decimal(8,3)
     );

     create table public.card_joined_strategy(
     id INTEGER,
     cardnumber varchar(20),
     FOREIGN KEY (id)
     REFERENCES payment_joined_strategy(id)
     )

     create table public.bankcheck_joined_strategy(
     id INTEGER,
     checknumber varchar(20),
     FOREIGN KEY (id)
     REFERENCES payment_joined_strategy(id)
     )
 */
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="pmode", discriminatorType = DiscriminatorType.STRING)
@Table(name="payment_joined_strategy")
public abstract class Payment {

    @Id
    private int id;
    private double amount;

    public Payment() {
    }

    public Payment(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
