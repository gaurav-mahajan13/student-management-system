# Student Management System

A Spring Boot REST API project for managing student records.

## Features

* Create Student
* Get All Students
* Get Student By ID
* Update Student
* Delete Student
* Search By Email
* Search By Course
* Pagination
* Sorting
* Validation
* Exception Handling
* Logging
* Swagger API Documentation
* PostgreSQL Integration

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Swagger/OpenAPI
* Git & GitHub

## API Endpoints

### Student APIs

| Method | Endpoint                  |
| ------ |---------------------------|
| GET    | /students                 |
| GET    | /students/{name}          |
| POST   | /students                 |
| PUT    | /students/{id}            |
| DELETE | /students/{id}            |
| GET    | /students/email/{email}   |
| GET    | /students/course/{course} |
| GET    | /students/page            |

## Project Structure

controller

service

repository

entity

dto

exception

## Future Enhancements

* Spring Security
* JWT Authentication
* Role Based Access
* Unit Testing
* AI Student Assistant

## Author

Gaurav Mahajan
