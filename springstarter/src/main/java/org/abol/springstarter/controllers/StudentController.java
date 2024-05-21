package org.abol.springstarter.controllers;

import org.abol.springstarter.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String getStudent(Model model) {
        Student student = new Student();
        student.setName("John");
        student.setId(123);
        student.setGender('M');
        model.addAttribute("student", student);
        return "student";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent( @ModelAttribute Student student, Model model) {

        model.addAttribute("student", student);
        return "student-details";
    }



    @GetMapping("/showForm2")
    public String showForm2(Model model) {
        model.addAttribute("student", new Student());
        return "form2";
    }



}
