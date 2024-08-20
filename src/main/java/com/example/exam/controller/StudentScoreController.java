package com.example.exam.controller;

import com.example.exam.entity.StudentScore;
import com.example.exam.service.StudentScoreService;
import com.example.exam.service.StudentService;
import com.example.exam.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studentScores")
public class StudentScoreController {

    private final StudentScoreService studentScoreService;
    private final StudentService studentService;
    private final SubjectService subjectService;

    public StudentScoreController(StudentScoreService theStudentScoreService, StudentService theStudentService, SubjectService theSubjectService) {
        studentScoreService = theStudentScoreService;
        studentService = theStudentService;
        subjectService = theSubjectService;
    }

    @GetMapping("/list")
    public String listStudentScores(Model theModel) {
        List<StudentScore> theStudentScores = studentScoreService.findAll();
        theModel.addAttribute("studentScores", theStudentScores);
        return "studentScores/list-studentScores";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        StudentScore theStudentScore = new StudentScore();
        theModel.addAttribute("studentScore", theStudentScore);
        theModel.addAttribute("students", studentService.findAll());
        theModel.addAttribute("subjects", subjectService.findAll());
        return "studentScores/studentScore-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentScoreId") int theId, Model theModel) {
        StudentScore theStudentScore = studentScoreService.findById(theId);
        theModel.addAttribute("studentScore", theStudentScore);
        theModel.addAttribute("students", studentService.findAll());
        theModel.addAttribute("subjects", subjectService.findAll());
        return "studentScores/studentScore-form";
    }

    @PostMapping("/save")
    public String saveStudentScore(@ModelAttribute("studentScore") StudentScore theStudentScore) {
        studentScoreService.save(theStudentScore);
        return "redirect:/studentScores/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("studentScoreId") int theId) {
        studentScoreService.deleteById(theId);
        return "redirect:/studentScores/list";
    }
}
