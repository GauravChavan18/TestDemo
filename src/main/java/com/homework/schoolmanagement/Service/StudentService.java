package com.homework.schoolmanagement.Service;

import com.homework.schoolmanagement.Entites.StudentEntites;
import com.homework.schoolmanagement.Repositories.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private  final StudentRepo studentrepo;

    public StudentService(StudentRepo studentrepo) {
        this.studentrepo = studentrepo;
    }


    public StudentEntites addstudent(StudentEntites student) {

        System.out.println(student.getName());
        return studentrepo.save(student);

    }

    public StudentEntites getStudentById(int studentId) {

        StudentEntites student =studentrepo.findById(studentId).orElse(null);

        return student;

    }
}
