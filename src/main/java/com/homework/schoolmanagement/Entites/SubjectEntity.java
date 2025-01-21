package com.homework.schoolmanagement.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject_table")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    @ManyToMany
    @JoinTable(name = "student_subject_mapping" ,
        joinColumns = @JoinColumn(name = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntites> students;


    @ManyToOne()
    @JoinColumn(name = "assosiate_pofessor")
    @JsonIgnore
    private ProfessorEntity assosiateProfessor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudentEntites> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntites> students) {
        this.students = students;
    }

    public ProfessorEntity getAssosiateProfessor() {
        return assosiateProfessor;
    }

    public void setAssosiateProfessor(ProfessorEntity assosiateProfessor) {
        this.assosiateProfessor = assosiateProfessor;
    }

}
