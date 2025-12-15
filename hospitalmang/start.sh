#!/bin/bash

echo "🏥 Starting Hospital Management System..."
echo "📦 Building with Maven..."

mvn clean package -DskipTests

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    echo "🚀 Starting application..."
    java -jar target/hospital-management-1.0.0.jar
else
    echo "❌ Build failed. Please check the errors above."
    exit 1
fi