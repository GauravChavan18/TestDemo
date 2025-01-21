package com.homework.schoolmanagement.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepo extends JpaRepository<com.homework.schoolmanagement.Entites.AdmissionRecordEntity, Integer> {
}
