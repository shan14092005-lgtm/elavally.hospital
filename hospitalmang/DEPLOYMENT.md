# Hospital Management System - Deployment Guide

## Quick Deploy to Railway (Recommended - Free & Easy)

### Option 1: Deploy via GitHub (Easiest)

1. **Create a GitHub Repository**
   - Go to https://github.com/new
   - Create a new repository (e.g., "hospital-management")
   - Don't initialize with README (we already have files)

2. **Push Your Code to GitHub**
   ```powershell
   git init
   git add .
   git commit -m "Initial commit"
   git branch -M main
   git remote add origin https://github.com/YOUR_USERNAME/hospital-management.git
   git push -u origin main
   ```

3. **Deploy on Railway**
   - Go to https://railway.app/
   - Click "Start a New Project"
   - Select "Deploy from GitHub repo"
   - Authorize Railway to access your GitHub
   - Select your "hospital-management" repository
   - Railway will automatically detect it's a Spring Boot app and deploy it
   - Wait 3-5 minutes for deployment to complete
   - Click "Generate Domain" to get your public URL

4. **Your Live URL**
   - You'll get a URL like: `https://hospital-management-production.up.railway.app`
   - Your site will be live at this URL!

### Option 2: Deploy via Railway CLI

1. **Install Railway CLI**
   ```powershell
   npm install -g @railway/cli
   ```

2. **Login to Railway**
   ```powershell
   railway login
   ```

3. **Initialize and Deploy**
   ```powershell
   railway init
   railway up
   ```

4. **Get Your URL**
   ```powershell
   railway domain
   ```

---

## Alternative: Deploy to Render (Also Free)

1. **Create Account**
   - Go to https://render.com/
   - Sign up for free

2. **Create New Web Service**
   - Click "New +" → "Web Service"
   - Connect your GitHub repository
   - Or use "Deploy from Git URL" if you pushed to GitHub

3. **Configure Service**
   - Name: hospital-management
   - Environment: Java
   - Build Command: `mvn clean package -DskipTests`
   - Start Command: `java -jar target/hospital-management-1.0.0.jar`
   - Instance Type: Free

4. **Deploy**
   - Click "Create Web Service"
   - Wait for deployment (5-10 minutes)
   - You'll get a URL like: `https://hospital-management.onrender.com`

---

## Alternative: Deploy to Heroku

1. **Install Heroku CLI**
   - Download from https://devcenter.heroku.com/articles/heroku-cli

2. **Login and Create App**
   ```powershell
   heroku login
   heroku create hospital-management-app
   ```

3. **Deploy**
   ```powershell
   git init
   git add .
   git commit -m "Initial commit"
   git push heroku main
   ```

4. **Open Your App**
   ```powershell
   heroku open
   ```

---

## Important Notes

### Database Consideration
Your app currently uses H2 in-memory database. This means:
- ✅ Works great for testing and demos
- ⚠️ Data is lost when the app restarts
- 💡 For production, consider upgrading to PostgreSQL (free on Railway/Render)

### Environment Variables
The app is configured to use `PORT` environment variable, which is automatically set by hosting platforms.

### Free Tier Limitations
- **Railway**: 500 hours/month free, $5 credit
- **Render**: Free tier sleeps after 15 minutes of inactivity (wakes up on request)
- **Heroku**: Free tier discontinued, requires paid plan

### Recommended: Railway
Railway is the easiest and most reliable free option for Spring Boot apps.

---

## After Deployment

Once deployed, your site will be accessible at the provided URL. You can:
- Share the link with anyone
- Access all pages (home, appointments, departments, etc.)
- Use the admin panel
- Book appointments

The site will be live 24/7 (on Railway) or wake up on request (on Render free tier).