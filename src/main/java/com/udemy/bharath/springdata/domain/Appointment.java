package com.udemy.bharath.springdata.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jd on 2018.11.16..
 *
 * Patient Scheduling
 *
 */
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp appointmentTime;
    private boolean started;
    private boolean ended;
    private String reason;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;



    public Appointment() {
    }

    public Appointment(Timestamp appointmentTime, boolean started, boolean ended, String reason, Patient patient, Doctor doctor) {
        this.appointmentTime = appointmentTime;
        this.started = started;
        this.ended = ended;
        this.reason = reason;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Timestamp appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointmentTime=" + appointmentTime +
                ", started=" + started +
                ", ended=" + ended +
                ", reason='" + reason + '\'' +
                '}';
    }
}
