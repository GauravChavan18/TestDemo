package com.homework.schoolmanagement.Controller;


import com.homework.schoolmanagement.Entites.StudentEntites;
import com.homework.schoolmanagement.Service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentContoller {


    private final StudentService studentservice;

    public StudentContoller(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @PostMapping("")
    public StudentEntites addstudent(@RequestBody StudentEntites student)
    {
        return studentservice.addstudent(student);
    }

    @GetMapping("/{studentId}")
    public StudentEntites getStudentById(@PathVariable int studentId)
    {
        return studentservice.getStudentById(studentId);
    }



}
