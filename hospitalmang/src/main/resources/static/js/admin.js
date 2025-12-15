const API_BASE_URL = 'http://localhost:8080/api';

// Load appointments
async function loadAppointments(status = '') {
    try {
        const url = status 
            ? `${API_BASE_URL}/appointments/status/${status}`
            : `${API_BASE_URL}/appointments`;
        
        const response = await fetch(url);
        const appointments = await response.json();
        
        displayAppointments(appointments);
    } catch (error) {
        console.error('Error loading appointments:', error);
        document.getElementById('appointments-tbody').innerHTML = 
            '<tr><td colspan="7" class="error">Failed to load appointments. Please try again later.</td></tr>';
    }
}

function displayAppointments(appointments) {
    const tbody = document.getElementById('appointments-tbody');
    
    if (appointments.length === 0) {
        tbody.innerHTML = '<tr><td colspan="7">No appointments found.</td></tr>';
        return;
    }
    
    tbody.innerHTML = appointments.map(apt => `
        <tr>
            <td>${apt.id}</td>
            <td>${apt.patientName}</td>
            <td>${apt.patientPhone}</td>
            <td>${apt.doctor.name}</td>
            <td>${formatDateTime(apt.appointmentDateTime)}</td>
            <td><span class="status-badge status-${apt.status.toLowerCase()}">${apt.status}</span></td>
            <td>
                <button onclick="updateStatus(${apt.id}, 'Completed')" class="btn-action btn-complete">Complete</button>
                <button onclick="updateStatus(${apt.id}, 'Cancelled')" class="btn-action btn-cancel">Cancel</button>
                <button onclick="deleteAppointment(${apt.id})" class="btn-action btn-delete">Delete</button>
            </td>
        </tr>
    `).join('');
}

function formatDateTime(dateTimeString) {
    const date = new Date(dateTimeString);
    return date.toLocaleString('en-IN', {
        year: 'numeric',
        month: 'short',
        day: 'numeric',
        hour: '2-digit',
        minute: '2-digit'
    });
}

// Update appointment status
async function updateStatus(id, status) {
    try {
        const response = await fetch(`${API_BASE_URL}/appointments/${id}`);
        const appointment = await response.json();
        
        appointment.status = status;
        
        const updateResponse = await fetch(`${API_BASE_URL}/appointments/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(appointment)
        });
        
        if (updateResponse.ok) {
            loadAppointments();
        } else {
            alert('Failed to update appointment status');
        }
    } catch (error) {
        console.error('Error updating appointment:', error);
        alert('Failed to update appointment status');
    }
}

// Delete appointment
async function deleteAppointment(id) {
    if (!confirm('Are you sure you want to delete this appointment?')) {
        return;
    }
    
    try {
        const response = await fetch(`${API_BASE_URL}/appointments/${id}`, {
            method: 'DELETE'
        });
        
        if (response.ok) {
            loadAppointments();
        } else {
            alert('Failed to delete appointment');
        }
    } catch (error) {
        console.error('Error deleting appointment:', error);
        alert('Failed to delete appointment');
    }
}