-- Database schema for SMS (Student Management System)
-- Run with: mysql -u root -p < database/schema.sql

CREATE DATABASE IF NOT EXISTS student_management_system;
USE student_management_system;

CREATE TABLE IF NOT EXISTS student (
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    email   VARCHAR(150) NOT NULL UNIQUE,
    course  VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);
