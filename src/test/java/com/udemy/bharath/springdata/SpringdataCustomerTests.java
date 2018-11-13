package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Address;
import com.udemy.bharath.springdata.domain.Customer;
import com.udemy.bharath.springdata.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataCustomerTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Customer customer = new Customer("Holly",
				new Address("54. street", "New York", "NY", "67889", "USA"));
		customerRepository.save(customer);
	}


}
