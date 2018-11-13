package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Employee;
import com.udemy.bharath.springdata.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataEmployeeTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Employee employee = new Employee("Jerry");
		employeeRepository.save(employee);
	}

	@Test
	public void testRead() {
		Employee Employee = employeeRepository.findById(1L).orElse(null);
		assertNotNull(Employee);
		assertEquals("Iphone", Employee.getName());
	}

	@Test
	public void testUpdate() {
		Employee Employee = employeeRepository.findById(1L).orElse(null);
		Employee.setName("Jack");
		employeeRepository.save(Employee);
	}

	@Test
	public void testDelete() {
		if (employeeRepository.existsById(1L)) {
			Employee Employee = employeeRepository.findById(1L).orElse(null);
			employeeRepository.delete(Employee);
			System.out.println("-----------------------------------");
			System.out.println("Employee with ID=1 is deleted");
			System.out.println("-----------------------------------");
		} else {
			System.out.println("-----------------------------------");
			System.out.println("Employee with ID=1 does not exists");
			System.out.println("-----------------------------------");
		}

	}

	@Test
	public void testCount() {
		assertEquals(1, employeeRepository.count());
	}

}
