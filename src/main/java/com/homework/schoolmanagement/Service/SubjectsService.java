package com.homework.schoolmanagement.Service;


import com.homework.schoolmanagement.Entites.StudentEntites;
import com.homework.schoolmanagement.Entites.SubjectEntity;
import com.homework.schoolmanagement.Repositories.StudentRepo;
import com.homework.schoolmanagement.Repositories.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectsService {

    private final SubjectRepo subjectRepo;
    private final StudentRepo studentRepo;

    public SubjectsService(SubjectRepo subjectRepo, StudentRepo studentRepo) {
        this.subjectRepo = subjectRepo;
        this.studentRepo = studentRepo;
    }

    public SubjectEntity addSubject(SubjectEntity subject) {
        return subjectRepo.save(subject);
    }

    public SubjectEntity getSubjectById(int subjectid) {
        return subjectRepo.findById(subjectid).orElse(null);
    }

    public SubjectEntity AssignSubjectToStudent(int subjectid, int studentid) {

        Optional<SubjectEntity> subjectentities=subjectRepo.findById(subjectid);
        Optional<StudentEntites> studententities =studentRepo.findById(studentid);

        return subjectentities.flatMap(subject ->
                studententities.map(student ->{
                 subject.getStudents().add(student);
                 subjectRepo.save(subject);
                 return subject;
                })).orElse(null);

    }
}
