package com.example.exam.controller;

import com.example.exam.entity.Subject;
import com.example.exam.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService theSubjectService) {
        subjectService = theSubjectService;
    }

    @GetMapping("/list")
    public String listSubjects(Model theModel) {
        List<Subject> theSubjects = subjectService.findAll();
        theModel.addAttribute("subjects", theSubjects);
        return "subjects/list-subjects";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Subject theSubject = new Subject();
        theModel.addAttribute("subject", theSubject);
        return "subjects/subject-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("subjectId") int theId, Model theModel) {
        Subject theSubject = subjectService.findById(theId);
        theModel.addAttribute("subject", theSubject);
        return "subjects/subject-form";
    }

    @PostMapping("/save")
    public String saveSubject(@ModelAttribute("subject") Subject theSubject) {
        subjectService.save(theSubject);
        return "redirect:/subjects/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("subjectId") int theId) {
        subjectService.deleteById(theId);
        return "redirect:/subjects/list";
    }
}
