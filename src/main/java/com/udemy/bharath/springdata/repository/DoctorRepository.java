package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Doctor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd on 2018.11.16..
 *
 * Patient Scheduling
 *
 */
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
