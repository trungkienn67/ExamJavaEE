package com.example.exam.service;

import com.example.exam.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();
    Subject findById(int theId);
    void save(Subject theSubject);
    void deleteById(int theId);
}
