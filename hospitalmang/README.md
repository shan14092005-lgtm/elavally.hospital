# 🏥 Hospital Management System

A modern, full-featured hospital management system built with Spring Boot and vanilla JavaScript.

## 🌟 Features

- 📅 **Appointment Booking** - Patients can book appointments with doctors
- 👨‍⚕️ **Doctor Management** - View available doctors by specialization
- 🏢 **Department Information** - Browse hospital departments
- 👔 **Admin Panel** - Manage appointments and view statistics
- 📱 **Responsive Design** - Works on all devices
- 🔒 **Secure** - Built with Spring Boot security best practices

## 🚀 Quick Deploy (Easiest Way!)

### **Deploy to Replit (No Git Required!)**

1. Go to **https://replit.com/** and sign up
2. Click **"+ Create Repl"** → Choose **"Java"**
3. Upload this entire project folder
4. Click **"Run"**
5. Get your live URL instantly! 🎉

**📖 Detailed Guide**: See [REPLIT_DEPLOYMENT.md](REPLIT_DEPLOYMENT.md)

---

## 💻 Run Locally

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Steps
```bash
# Clone or download this repository
cd hospitalmang

# Run the application
mvn spring-boot:run

# Open in browser
http://localhost:8080
```

---

## 🌐 Deploy to Cloud (Alternative Methods)

### **Railway** (Recommended for Production)
- Push to GitHub
- Connect to Railway
- Auto-deploy
- Guide: [DEPLOYMENT.md](DEPLOYMENT.md)

### **Render** (Free, No Credit Card)
- Push to GitHub
- Connect to Render
- Auto-deploy with `render.yaml`

### **Glitch** (Quick & Easy)
- Upload files to Glitch
- Instant deployment
- URL: `https://hospital-management.glitch.me`

---

## 📁 Project Structure

```
hospital-management/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/hospital/
│       │       ├── HospitalApplication.java
│       │       ├── controller/
│       │       ├── model/
│       │       ├── repository/
│       │       └── config/
│       └── resources/
│           ├── application.properties
│           └── static/
│               ├── index.html
│               ├── appointment.html
│               ├── departments.html
│               ├── about.html
│               ├── contact.html
│               ├── admin_login.html
│               ├── admin_appointments.html
│               ├── css/
│               ├── js/
│               └── img/
├── pom.xml
└── README.md
```

---

## 🛠️ Technology Stack

**Backend:**
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (in-memory)
- Maven

**Frontend:**
- HTML5
- CSS3
- Vanilla JavaScript
- Responsive Design

---

## 📱 Pages

- **Home** (`/`) - Landing page with features
- **Appointments** (`/appointment.html`) - Book appointments
- **Departments** (`/departments.html`) - View departments
- **About** (`/about.html`) - About the hospital
- **Contact** (`/contact.html`) - Contact information
- **Admin Login** (`/admin_login.html`) - Admin authentication
- **Admin Panel** (`/admin_appointments.html`) - Manage appointments

---

## 🔧 Configuration

The application uses H2 in-memory database by default. Configuration is in `src/main/resources/application.properties`:

```properties
server.port=8080
spring.datasource.url=jdbc:h2:mem:hospitaldb
spring.h2.console.enabled=true
```

### H2 Console
Access at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:hospitaldb`
- Username: `sa`
- Password: (leave empty)

---

## 📊 API Endpoints

### Doctors
- `GET /api/doctors` - Get all doctors
- `GET /api/doctors/specialization/{spec}` - Get doctors by specialization

### Appointments
- `GET /api/appointments` - Get all appointments
- `POST /api/appointments` - Create new appointment
- `PUT /api/appointments/{id}/status` - Update appointment status
- `DELETE /api/appointments/{id}` - Delete appointment

---

## 🎨 Customization

### Change Colors
Edit `src/main/resources/static/css/styles.css`

### Add More Departments
Edit `src/main/resources/static/departments.html`

### Modify Database
Update `src/main/java/com/example/hospital/config/DataLoader.java`

---

## 📝 License

This project is open source and available under the MIT License.

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

## 👨‍💻 Author

Created with ❤️ for learning and demonstration purposes.

---

## 🙏 Acknowledgments

- Spring Boot team for the amazing framework
- Bootstrap for UI components
- Font Awesome for icons

---

## 📞 Support

For deployment help, see:
- [REPLIT_DEPLOYMENT.md](REPLIT_DEPLOYMENT.md) - Easiest deployment
- [DEPLOYMENT.md](DEPLOYMENT.md) - Production deployment

**Happy Coding! 🚀**