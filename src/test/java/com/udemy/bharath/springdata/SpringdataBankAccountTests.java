package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Address;
import com.udemy.bharath.springdata.domain.Customer;
import com.udemy.bharath.springdata.repository.BankAccountRepository;
import com.udemy.bharath.springdata.repository.CustomerRepository;
import com.udemy.bharath.springdata.service.BankAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataBankAccountTests {

	@Autowired
	BankAccountService bankAccountService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testTransfer() {
		bankAccountService.transfer(500);
	}


}
