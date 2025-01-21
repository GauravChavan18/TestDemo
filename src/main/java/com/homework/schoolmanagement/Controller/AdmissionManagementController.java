package com.homework.schoolmanagement.Controller;


import com.homework.schoolmanagement.Entites.AdmissionRecordEntity;
import com.homework.schoolmanagement.Repositories.AdmissionRecordRepo;
import com.homework.schoolmanagement.Service.AdmissionManagementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admissionmanagment")
public class AdmissionManagementController {


    private final AdmissionManagementService admissionManagementService;


    public AdmissionManagementController(AdmissionManagementService admissionManagementService) {
        this.admissionManagementService = admissionManagementService;
    }

    @GetMapping("/{admissionmanagementid}")
    public AdmissionRecordEntity getRecordById(@PathVariable int admissionmanagementid)
    {
        return admissionManagementService.getRecordById(admissionmanagementid);
    }

    @PostMapping("")
    public AdmissionRecordEntity addRecord(@RequestBody AdmissionRecordEntity admissionRecord)
    {
        return admissionManagementService.addRecord(admissionRecord);
    }

    @PutMapping("/{admissionmanagementid}/student/{studentid}")
    public AdmissionRecordEntity assignAdmissionRecordaToStudent(@PathVariable int admissionmanagementid ,
                                           @PathVariable int studentid)
    {
        return admissionManagementService.assignAdmissionRecordaToStudent(admissionmanagementid,studentid);
    }

    @GetMapping("/getrecordofstudent/{studentid}")
    public AdmissionRecordEntity getAssignRecordOfRecord(@PathVariable int studentid)
    {
        return admissionManagementService.getAssignRecordOfRecord(studentid);
    }



}
