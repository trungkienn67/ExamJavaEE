package com.example.exam.service;

import com.example.exam.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int theId);
    void save(Student theStudent);
    void deleteById(int theId);
}
