package com.example.hospital.controller;

import com.example.hospital.model.Appointment;
import com.example.hospital.model.Doctor;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    // Doctor endpoints
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/doctors/specialization/{specialization}")
    public List<Doctor> getDoctorsBySpecialization(@PathVariable String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }
    
    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }
    
    @PutMapping("/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            doctor.setName(doctorDetails.getName());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            doctor.setPhone(doctorDetails.getPhone());
            doctor.setEmail(doctorDetails.getEmail());
            doctor.setQualification(doctorDetails.getQualification());
            doctor.setExperience(doctorDetails.getExperience());
            doctor.setAvailability(doctorDetails.getAvailability());
            
            Doctor updatedDoctor = doctorRepository.save(doctor);
            return ResponseEntity.ok(updatedDoctor);
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // Appointment endpoints
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/appointments/status/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable String status) {
        return appointmentRepository.findByStatus(status);
    }
    
    @PostMapping("/appointments")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
    }
    
    @PutMapping("/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            appointment.setPatientName(appointmentDetails.getPatientName());
            appointment.setPatientPhone(appointmentDetails.getPatientPhone());
            appointment.setPatientEmail(appointmentDetails.getPatientEmail());
            appointment.setPatientAge(appointmentDetails.getPatientAge());
            appointment.setDoctor(appointmentDetails.getDoctor());
            appointment.setAppointmentDateTime(appointmentDetails.getAppointmentDateTime());
            appointment.setReason(appointmentDetails.getReason());
            appointment.setStatus(appointmentDetails.getStatus());
            
            Appointment updatedAppointment = appointmentRepository.save(appointment);
            return ResponseEntity.ok(updatedAppointment);
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}