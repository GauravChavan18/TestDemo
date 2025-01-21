package com.homework.schoolmanagement.Service;

import com.homework.schoolmanagement.Entites.AdmissionRecordEntity;
import com.homework.schoolmanagement.Entites.StudentEntites;
import com.homework.schoolmanagement.Repositories.AdmissionRecordRepo;
import com.homework.schoolmanagement.Repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionManagementService {

    private final AdmissionRecordRepo admissionRecordRepo;
    private final StudentRepo studentRepo;

    public AdmissionManagementService(AdmissionRecordRepo admissionRecordRepo, StudentRepo studentRepo) {
        this.admissionRecordRepo = admissionRecordRepo;
        this.studentRepo = studentRepo;
    }

    public AdmissionRecordEntity addRecord(AdmissionRecordEntity admissionRecord) {
        return admissionRecordRepo.save(admissionRecord);
    }


    public AdmissionRecordEntity getRecordById(int admissionID) {
        return admissionRecordRepo.findById(admissionID).orElse(null);
    }

    public AdmissionRecordEntity assignAdmissionRecordaToStudent(int admissionmanagementid, int studentid) {

        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepo.findById(admissionmanagementid);
        Optional<StudentEntites> studentEntites =studentRepo.findById(studentid);

        return admissionRecordEntity.flatMap(record ->
            studentEntites.map((student)->{
                record.setStudent(student);
                admissionRecordRepo.save(record);
                return record;
            })).orElse(null);

    }

    public AdmissionRecordEntity getAssignRecordOfRecord(int studentid) {

        Optional<StudentEntites> studentEntites =studentRepo.findById(studentid);

        return studentEntites.map(student->
                    student.getStudentAdmissionRecord()
                ).orElse(null);


    }
}
