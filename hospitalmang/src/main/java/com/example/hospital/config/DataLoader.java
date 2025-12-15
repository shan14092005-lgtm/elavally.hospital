package com.example.hospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Load sample doctors
        Doctor doctor1 = new Doctor("Dr. M Shan", "Psychology", "+91-62351-31534");
        doctor1.setEmail("shan1409@gmail.com");
        doctor1.setQualification("MBBS, MS (Psychology)");
        doctor1.setExperience(15);
        doctor1.setAvailability("Mon-Fri: 9AM-5PM");
        
        Doctor doctor2 = new Doctor("Dr. Priya Sharma", "Cardiology", "+91-90000-00003");
        doctor2.setEmail("priya.sharma@hospital.com");
        doctor2.setQualification("MBBS, MD (Cardiology)");
        doctor2.setExperience(12);
        doctor2.setAvailability("Mon-Sat: 10AM-6PM");
        
        Doctor doctor3 = new Doctor("Dr. Amit Patel", "Pediatrics", "+91-90000-00004");
        doctor3.setEmail("amit.patel@hospital.com");
        doctor3.setQualification("MBBS, MD (Pediatrics)");
        doctor3.setExperience(10);
        doctor3.setAvailability("Mon-Fri: 8AM-4PM");
        
        Doctor doctor4 = new Doctor("Dr. Sneha Reddy", "Dermatology", "+91-90000-00005");
        doctor4.setEmail("sneha.reddy@hospital.com");
        doctor4.setQualification("MBBS, MD (Dermatology)");
        doctor4.setExperience(8);
        doctor4.setAvailability("Tue-Sat: 11AM-7PM");
        
        Doctor doctor5 = new Doctor("Dr. Rajesh Gupta", "Neurology", "+91-90000-00006");
        doctor5.setEmail("rajesh.gupta@hospital.com");
        doctor5.setQualification("MBBS, DM (Neurology)");
        doctor5.setExperience(20);
        doctor5.setAvailability("Mon-Fri: 9AM-5PM");
        
        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);
        doctorRepository.save(doctor3);
        doctorRepository.save(doctor4);
        doctorRepository.save(doctor5);
        
        System.out.println("Sample doctors loaded successfully!");
    }
}