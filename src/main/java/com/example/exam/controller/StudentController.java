package com.example.exam.controller;

import com.example.exam.entity.Student;
import com.example.exam.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    @GetMapping("/list")
    public String listStudents(Model theModel) {
        List<Student> theStudents = studentService.findAll();
        theModel.addAttribute("students", theStudents);
        return "students/list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "students/student-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
        Student theStudent = studentService.findById(theId);
        theModel.addAttribute("student", theStudent);
        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent) {
        studentService.save(theStudent);
        return "redirect:/students/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {
        studentService.deleteById(theId);
        return "redirect:/students/list";
    }
}
