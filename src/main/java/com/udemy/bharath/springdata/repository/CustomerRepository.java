package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd on 2018.11.13..
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
