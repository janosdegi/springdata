package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd on 2018.11.08..
 *
 * --------------------- Inheritence mapping ---------------------
 *
 */
public interface PaymentRepository extends CrudRepository<Payment, Integer> {



}
