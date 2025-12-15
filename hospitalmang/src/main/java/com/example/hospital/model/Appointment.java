package com.example.hospital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Patient name is required")
    private String patientName;
    
    @NotBlank(message = "Patient phone is required")
    private String patientPhone;
    
    private String patientEmail;
    
    private Integer patientAge;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @NotNull(message = "Doctor is required")
    private Doctor doctor;
    
    @NotNull(message = "Appointment date and time is required")
    private LocalDateTime appointmentDateTime;
    
    private String reason;
    
    private String status = "Scheduled";
    
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    public Appointment() {}
    
    public Appointment(String patientName, String patientPhone, Doctor doctor, LocalDateTime appointmentDateTime) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public String getPatientPhone() {
        return patientPhone;
    }
    
    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }
    
    public String getPatientEmail() {
        return patientEmail;
    }
    
    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }
    
    public Integer getPatientAge() {
        return patientAge;
    }
    
    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }
    
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}