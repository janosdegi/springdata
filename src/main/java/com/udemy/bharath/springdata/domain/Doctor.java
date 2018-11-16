package com.udemy.bharath.springdata.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jd on 2018.11.16..
 *
 * Patient Scheduling
 *
 */
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String speciality;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patients_doctors", joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
    List<Patient> patients;

    @OneToMany
    private List<Appointment> appointments;



    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String speciality, List<Patient> patients, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.patients = patients;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
