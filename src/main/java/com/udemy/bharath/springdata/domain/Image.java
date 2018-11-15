package com.udemy.bharath.springdata.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by jd on 2018.11.15..
 *
 * Save and Retrieve Files
 *
 */
@Entity
public class Image {

    @Id
    private long id;

    private String name;

//    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] data;

    public Image() {
    }

    public Image(Integer id, String name, byte[] data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
