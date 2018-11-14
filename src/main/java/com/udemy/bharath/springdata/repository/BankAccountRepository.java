package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.BankAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd on 2018.11.14..
 */
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
}
