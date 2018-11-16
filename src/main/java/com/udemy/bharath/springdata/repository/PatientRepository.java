package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd on 2018.11.16..
 *
 * Patient Scheduling
 *
 */
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
