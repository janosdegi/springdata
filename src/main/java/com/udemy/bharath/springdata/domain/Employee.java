package com.udemy.bharath.springdata.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by jd on 2018.10.23..
 */
@Entity
public class Employee {

//    @TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name",
//                    valueColumnName = "gen_val", allocationSize = 100, schema="public")
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")

    @GenericGenerator(name = "emp_id", strategy = "com.udemy.bharath.springdata.domain.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
