package com.homework.schoolmanagement.Controller;

import com.homework.schoolmanagement.Entites.SubjectEntity;
import com.homework.schoolmanagement.Service.SubjectsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectsController {

    private final SubjectsService subjectsService;

    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }

    @PostMapping("")
    public SubjectEntity addSubject(@RequestBody SubjectEntity subject)
    {
        return subjectsService.addSubject(subject);
    }

    @GetMapping("/{subjectid}")
    public SubjectEntity getSubjectById(@PathVariable int subjectid)
    {
        return subjectsService.getSubjectById(subjectid);
    }

    @PutMapping("/{subjectid}/student/{studentid}")
    public SubjectEntity AssignSubjectToStudent(@PathVariable int subjectid ,
                                                @PathVariable int studentid)
    {
        return subjectsService.AssignSubjectToStudent(subjectid,studentid);
    }
}
