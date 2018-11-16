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
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    @Embedded
    private Insurance insurance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patients_doctors", joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"))
    List<Doctor> doctors;

    @OneToMany
    private List<Appointment> appointments;


    public Patient() {
    }

    public Patient(String firstName, String lastName, String phone, Insurance insurance, List<Doctor> doctors, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.insurance = insurance;
        this.doctors = doctors;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", insurance=" + insurance +
                '}';
    }
}
