package com.homework.schoolmanagement.Repositories;

import com.homework.schoolmanagement.Entites.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<ProfessorEntity , Integer> {
}
