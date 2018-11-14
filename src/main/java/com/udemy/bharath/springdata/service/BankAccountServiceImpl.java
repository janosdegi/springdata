package com.udemy.bharath.springdata.service;

import com.udemy.bharath.springdata.domain.BankAccount;
import com.udemy.bharath.springdata.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by jd on 2018.11.14..
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public void transfer(int amount) {

        BankAccount obamasBankAccount = bankAccountRepository.findById(1).orElse(null);
        obamasBankAccount.setBal(obamasBankAccount.getBal() - amount);
        bankAccountRepository.save(obamasBankAccount);

        if (true)
            throw new RuntimeException();

        BankAccount trumpsBankAccount = bankAccountRepository.findById(2).orElse(null);
        trumpsBankAccount.setBal(trumpsBankAccount.getBal() + amount);
        bankAccountRepository.save(trumpsBankAccount);

    }

}
