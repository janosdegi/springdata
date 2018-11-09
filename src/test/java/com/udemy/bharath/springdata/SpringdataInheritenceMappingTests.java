package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Check;
import com.udemy.bharath.springdata.domain.CreditCard;
import com.udemy.bharath.springdata.domain.Employee;
import com.udemy.bharath.springdata.repository.EmployeeRepository;
import com.udemy.bharath.springdata.repository.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataInheritenceMappingTests {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateCreditCard() {
		CreditCard cc = new CreditCard();
		cc.setId(1);
		cc.setAmount(1200d);
		cc.setCardnumber("AT347-4354-5465");
		paymentRepository.save(cc);
	}

	@Test
	public void testCreateCheck() {
		Check ch = new Check();
		ch.setId(2);
		ch.setAmount(1700d);
		ch.setChecknumber("CH-4357834-435");
		paymentRepository.save(ch);
	}

	@Test
	public void testRead() {

	}



}
