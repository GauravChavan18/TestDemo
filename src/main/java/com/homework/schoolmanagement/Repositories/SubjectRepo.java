package com.homework.schoolmanagement.Repositories;

import com.homework.schoolmanagement.Entites.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectEntity , Integer> {
}
