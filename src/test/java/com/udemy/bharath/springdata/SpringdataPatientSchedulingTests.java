package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Appointment;
import com.udemy.bharath.springdata.domain.Doctor;
import com.udemy.bharath.springdata.domain.Insurance;
import com.udemy.bharath.springdata.domain.Patient;
import com.udemy.bharath.springdata.repository.AppointmentRepository;
import com.udemy.bharath.springdata.repository.DoctorRepository;
import com.udemy.bharath.springdata.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by jd on 2018.11.16..
 *
 * Patient Scheduling
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataPatientSchedulingTests {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	AppointmentRepository appointmentRepository;


	@Test
	public void testCreateDoctor() {
		doctorRepository.save(new Doctor("Sam", "Parnia", "ALL", null, null));
	}

	@Test
	public void testCreatePatient() {

		Doctor doctor = doctorRepository.findById(1L).orElse(null);
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		doctors.add(doctor);
		Patient patient = new Patient(	"Tom","Fooler","3243-6765",
									new Insurance("AEGON", 35d), Arrays.asList(doctor),
									null);
		patientRepository.save(patient);
	}

	@Test
	public void testCreateAppointment() {

		Doctor doctor = doctorRepository.findById(1L).orElse(null);
		Patient patient = patientRepository.findById(1L).orElse(null);

		Timestamp ts = new Timestamp((new Date()).getTime());

		Appointment appointment = new Appointment(ts, true, false, "CONTROL" , patient, doctor);
		appointmentRepository.save(appointment);
	}

}
