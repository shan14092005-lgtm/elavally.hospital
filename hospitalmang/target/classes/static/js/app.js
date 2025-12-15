const API_BASE_URL = 'http://localhost:8080/api';

// Load doctors for the doctors page
async function loadDoctors(specialization = '') {
    try {
        const url = specialization 
            ? `${API_BASE_URL}/doctors/specialization/${specialization}`
            : `${API_BASE_URL}/doctors`;
        
        const response = await fetch(url);
        const doctors = await response.json();
        
        displayDoctors(doctors);
        populateSpecializationFilter(doctors);
    } catch (error) {
        console.error('Error loading doctors:', error);
        document.getElementById('doctors-grid').innerHTML = 
            '<p class="error">Failed to load doctors. Please try again later.</p>';
    }
}

function displayDoctors(doctors) {
    const grid = document.getElementById('doctors-grid');
    
    if (doctors.length === 0) {
        grid.innerHTML = '<p>No doctors found.</p>';
        return;
    }
    
    grid.innerHTML = doctors.map(doctor => `
        <div class="doctor-card">
            <h3>${doctor.name}</h3>
            <p class="specialization">${doctor.specialization}</p>
            <div class="doctor-details">
                <p><strong>Qualification:</strong> ${doctor.qualification || 'N/A'}</p>
                <p><strong>Experience:</strong> ${doctor.experience || 'N/A'} years</p>
                <p><strong>Phone:</strong> ${doctor.phone}</p>
                <p><strong>Email:</strong> ${doctor.email || 'N/A'}</p>
                <p><strong>Availability:</strong> ${doctor.availability || 'N/A'}</p>
            </div>
            <a href="appointment.html" class="btn btn-secondary">Book Appointment</a>
        </div>
    `).join('');
}

function populateSpecializationFilter(doctors) {
    const filter = document.getElementById('specialization-filter');
    if (!filter) return;
    
    const specializations = [...new Set(doctors.map(d => d.specialization))];
    
    const currentValue = filter.value;
    filter.innerHTML = '<option value="">All Specializations</option>' +
        specializations.map(spec => 
            `<option value="${spec}">${spec}</option>`
        ).join('');
    
    if (currentValue) {
        filter.value = currentValue;
    }
}

// Load doctors for appointment booking
async function loadDoctorsForAppointment() {
    try {
        const response = await fetch(`${API_BASE_URL}/doctors`);
        const doctors = await response.json();
        
        const select = document.getElementById('doctor-select');
        select.innerHTML = '<option value="">Choose a doctor...</option>' +
            doctors.map(doctor => 
                `<option value="${doctor.id}">${doctor.name} - ${doctor.specialization}</option>`
            ).join('');
    } catch (error) {
        console.error('Error loading doctors:', error);
    }
}

// Book appointment
async function bookAppointment() {
    const form = document.getElementById('appointment-form');
    const messageDiv = document.getElementById('message');
    
    const formData = {
        patientName: form.patientName.value,
        patientPhone: form.patientPhone.value,
        patientEmail: form.patientEmail.value || null,
        patientAge: form.patientAge.value ? parseInt(form.patientAge.value) : null,
        doctor: { id: parseInt(form.doctorId.value) },
        appointmentDateTime: `${form.appointmentDate.value}T${form.appointmentTime.value}:00`,
        reason: form.reason.value || null,
        status: 'Scheduled'
    };
    
    try {
        const response = await fetch(`${API_BASE_URL}/appointments`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });
        
        if (response.ok) {
            messageDiv.className = 'message success';
            messageDiv.textContent = 'Appointment booked successfully!';
            form.reset();
            
            setTimeout(() => {
                messageDiv.textContent = '';
                messageDiv.className = 'message';
            }, 5000);
        } else {
            throw new Error('Failed to book appointment');
        }
    } catch (error) {
        console.error('Error booking appointment:', error);
        messageDiv.className = 'message error';
        messageDiv.textContent = 'Failed to book appointment. Please try again.';
    }
}