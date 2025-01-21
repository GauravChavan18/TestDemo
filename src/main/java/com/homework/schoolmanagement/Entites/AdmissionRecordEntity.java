package com.homework.schoolmanagement.Entites;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admission_stratergy_table")
public class AdmissionRecordEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id")
    int id;

    int fees;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntites student;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public StudentEntites getStudent() {
        return student;
    }

    public void setStudent(StudentEntites student) {
        this.student = student;
    }


}
