# Campus Booking System

A Spring Boot application demonstrating an automated CI/CD pipeline with GitHub Actions, Gitleaks, Docker, GitHub Container Registry, Kubernetes and Ansible.

## 1. Technologies Used

- Java 17
- Spring Boot
- Maven
- Git and GitHub
- GitHub Actions
- Gitleaks
- Docker
- GitHub Container Registry (GHCR)
- Kubernetes
- Ansible
- AWS EKS (planned deployment target)

## 2. Application Features

- Application health and status endpoint
- Create campus room bookings
- Retrieve all bookings
- REST API implementation

## 3. API Endpoints

| Method | Endpoint | Description |
| GET | /api/status | Check application status |
| GET | /api/bookings | Retrieve bookings |
| POST | /api/bookings | Create a booking |
| GET | /actuator/health | Application health check |

## 4. CI/CD Pipeline

GitHub Actions automates the following stages:

1. Checkout source code.
2. Scan source code for exposed secrets using Gitleaks.
3. Set up Java 17.
4. Build and test the application using Maven.
5. Build the Docker image.
6. Publish the image to GitHub Container Registry.

## 5. Docker Image

ghcr.io/haricodex/campus-booking:latest

## 6. Kubernetes Deployment

Kubernetes manifests are available in the k8s directory.

- deployment.yaml: Configures two application replicas.
- service.yaml: Exposes the application using a LoadBalancer service.

## 7. Ansible Automation

The ansible directory contains:

- inventory.ini
- deploy.yml

The playbook automates Kubernetes manifest application and deployment rollout verification.

## 8. Run Locally

Start the application:

./mvnw spring-boot:run

Application URL:

http://localhost:8081/api/status

## 9. Project Structure

campus-booking/
+-- .github/workflows/ci-cd.yml
+-- ansible/
+-- k8s/
+-- src/
+-- Dockerfile
+-- .dockerignore
+-- pom.xml
+-- README.md

## 10. Deployment Status

The CI pipeline, security scan, Maven build, Docker image creation and GHCR publishing have been completed successfully.

Kubernetes manifests and Ansible automation have been prepared. AWS EKS deployment is pending AWS account verification and cluster setup.
