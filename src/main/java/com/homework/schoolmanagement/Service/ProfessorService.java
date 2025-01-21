package com.homework.schoolmanagement.Service;

import com.homework.schoolmanagement.Entites.ProfessorEntity;
import com.homework.schoolmanagement.Entites.StudentEntites;
import com.homework.schoolmanagement.Entites.SubjectEntity;
import com.homework.schoolmanagement.Repositories.ProfessorRepo;
import com.homework.schoolmanagement.Repositories.StudentRepo;
import com.homework.schoolmanagement.Repositories.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepo professorRepo;
    private final SubjectRepo subjectRepo;
    private final StudentRepo studentRepo;

    public ProfessorService(ProfessorRepo professorRepo , SubjectRepo subjectRepo , StudentRepo studentRepo) {
        this.professorRepo = professorRepo;
        this.subjectRepo=subjectRepo;
        this.studentRepo=studentRepo;
    }

    public ProfessorEntity getProfessorById(int professorid) {
        return professorRepo.findById(professorid).orElse(null);
    }

    public ProfessorEntity addProfessor(ProfessorEntity professorEntity) {
        return professorRepo.save(professorEntity);
    }

    public ProfessorEntity AssignSubjectToProfessor(int professorid, int subjectid) {

        Optional<ProfessorEntity> professorEntity = professorRepo.findById(professorid);
        Optional<SubjectEntity> subjectEntity=subjectRepo.findById(subjectid);

        professorEntity.flatMap(professor ->
                subjectEntity.map(subject -> {
                    subject.setAssosiateProfessor(professor);
                    professor.getSubjectTeach().add(subject);
//                    professorRepo.save(professor);
                      subjectRepo.save(subject);
                    return professor;

                }));
        return professorEntity.orElse(null);

    }


    public ProfessorEntity AssignStudentsToProfessor(int professorid, int studentid) {
        Optional<ProfessorEntity> professorEntity = professorRepo.findById(professorid);
        Optional<StudentEntites> studentEntites = studentRepo.findById(studentid);

        return professorEntity.flatMap(professor ->
                studentEntites.map(student ->{
                    professor.getAssignStudents().add(student);
                    professorRepo.save(professor);
                    return professor;
                })
                ).orElse(null);

    }
}
