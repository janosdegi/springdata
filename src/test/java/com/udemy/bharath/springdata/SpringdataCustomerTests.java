package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Address;
import com.udemy.bharath.springdata.domain.Customer;
import com.udemy.bharath.springdata.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
@SpringBootTest
public class SpringdataCustomerTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	public TaskExecutor taskExecutor;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Customer customer = new Customer("Holly",
				new Address("54. street", "New York", "NY", "67889", "USA"));
		customerRepository.save(customer);
	}

	@Test
	public void testThread() {
		taskExecutor.execute(()-> {
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(" _2_ ");
		});
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" _1_ ");
	}

}
