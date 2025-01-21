package com.homework.schoolmanagement.Entites;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Professor_table")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String name;

    @OneToMany(mappedBy = "assosiateProfessor" , fetch = FetchType.EAGER)
    private List<SubjectEntity> subjectTeach;


    @ManyToMany
    @JoinTable(name = "student_professor_table" ,
            joinColumns = @JoinColumn(name = "professorId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    private List<StudentEntites> assignStudents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SubjectEntity> getSubjectTeach() {
        return subjectTeach;
    }

    public void setSubjectTeach(List<SubjectEntity> subjectTeach) {
        this.subjectTeach = subjectTeach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntites> getAssignStudents() {
        return assignStudents;
    }

    public void setAssignStudents(List<StudentEntites> assignStudents) {
        this.assignStudents = assignStudents;
    }
}
