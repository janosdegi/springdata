package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd on 2018.10.22..
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
