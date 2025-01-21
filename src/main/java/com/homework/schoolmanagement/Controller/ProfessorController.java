package com.homework.schoolmanagement.Controller;


import com.homework.schoolmanagement.Entites.ProfessorEntity;
import com.homework.schoolmanagement.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {


    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @PostMapping("")
    private ProfessorEntity addProfessor(@RequestBody ProfessorEntity professorEntity)
    {
        return professorService.addProfessor(professorEntity);
    }

    @GetMapping("/{professorid}")
    private ProfessorEntity getProfessorById(@PathVariable int professorid)
    {
        return professorService.getProfessorById(professorid);
    }

    @PutMapping("/{professorid}/subject/{subjectid}")
    private ProfessorEntity AssignSubjectToProfessor(@PathVariable int professorid,
                                                     @PathVariable int subjectid
                                                     )
    {
        return professorService.AssignSubjectToProfessor(professorid,subjectid);
    }

    @PutMapping("/{professorid}/student/{studentid}")
    private ProfessorEntity AssignStudentsToProfessor(@PathVariable int professorid,
                                                     @PathVariable int studentid
    )
    {
        return professorService.AssignStudentsToProfessor(professorid,studentid);
    }
}
