package com.homework.schoolmanagement.Entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_entity")
public class StudentEntites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    int id;

    String name;

    @OneToOne(mappedBy = "student" ,fetch = FetchType.LAZY)
    @JsonIgnore
    private AdmissionRecordEntity studentAdmissionRecord;


    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<SubjectEntity> subjects;

    @ManyToMany(mappedBy = "assignStudents")
    @JsonIgnore
    private List<ProfessorEntity> studentUnderProfessor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdmissionRecordEntity getStudentAdmissionRecord() {
        return studentAdmissionRecord;
    }

    public void setStudentAdmissionRecord(AdmissionRecordEntity studentAdmissionRecord) {
        this.studentAdmissionRecord = studentAdmissionRecord;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

    public List<ProfessorEntity> getStudentUnderProfessor() {
        return studentUnderProfessor;
    }

    public void setStudentUnderProfessor(List<ProfessorEntity> studentUnderProfessor) {
        this.studentUnderProfessor = studentUnderProfessor;
    }
}
