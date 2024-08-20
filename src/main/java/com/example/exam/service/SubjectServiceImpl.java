package com.example.exam.service;

import com.example.exam.entity.Subject;
import com.example.exam.dao.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository theSubjectRepository) {
        subjectRepository = theSubjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(int theId) {
        Optional<Subject> result = subjectRepository.findById(theId);
        return result.orElse(null);
    }

    @Override
    public void save(Subject theSubject) {
        subjectRepository.save(theSubject);
    }

    @Override
    public void deleteById(int theId) {
        subjectRepository.deleteById(theId);
    }
}
