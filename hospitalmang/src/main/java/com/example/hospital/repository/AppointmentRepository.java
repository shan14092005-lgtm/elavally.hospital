package com.example.hospital.repository;

import com.example.hospital.model.Appointment;
import com.example.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctor(Doctor doctor);
    List<Appointment> findByPatientPhone(String patientPhone);
    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Appointment> findByStatus(String status);
}