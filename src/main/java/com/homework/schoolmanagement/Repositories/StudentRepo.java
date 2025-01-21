package com.homework.schoolmanagement.Repositories;

import com.homework.schoolmanagement.Entites.StudentEntites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<StudentEntites , Integer> {

}
