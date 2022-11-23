package com.example.recruitingMicroservice.repositories;

import com.example.recruitingMicroservice.entity.Apply;
import com.example.recruitingMicroservice.entity.ApplyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, ApplyId> {

     List<Apply> findAll();

     List<Apply> findAppliesByIdIdApplicantIsContaining(Integer id_applicant);

     Apply findApplyById(ApplyId id);

     Apply save(Apply apply);

     @Override
     void delete(Apply apply);
}
