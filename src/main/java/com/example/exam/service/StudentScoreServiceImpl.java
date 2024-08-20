package com.example.exam.service;

import com.example.exam.entity.StudentScore;
import com.example.exam.dao.StudentScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentScoreServiceImpl implements StudentScoreService {

    private final StudentScoreRepository studentScoreRepository;

    public StudentScoreServiceImpl(StudentScoreRepository theStudentScoreRepository) {
        studentScoreRepository = theStudentScoreRepository;
    }

    @Override
    public List<StudentScore> findAll() {
        return studentScoreRepository.findAll();
    }

    @Override
    public StudentScore findById(int theId) {
        Optional<StudentScore> result = studentScoreRepository.findById(theId);
        return result.orElse(null);
    }

    @Override
    public void save(StudentScore theStudentScore) {
        studentScoreRepository.save(theStudentScore);
    }

    @Override
    public void deleteById(int theId) {
        studentScoreRepository.deleteById(theId);
    }
}
