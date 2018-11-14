package com.udemy.bharath.springdata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by jd on 2018.11.14..
 *
 * Transaction management
 *
 * Statements in a transaction means that these statements are one atomic work unit
 * all of them will be executed or nothing (All or nothing)
 * method => @Transactional
 *
 */
@Entity
@Table(name = "bankaccount")
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int accno;
    private String lastname;
    private String firstname;
    private int bal;

    public BankAccount() {
    }

    public BankAccount(int accno, String lastname, String firstname, int bal) {
        this.accno = accno;
        this.lastname = lastname;
        this.firstname = firstname;
        this.bal = bal;
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }
}
