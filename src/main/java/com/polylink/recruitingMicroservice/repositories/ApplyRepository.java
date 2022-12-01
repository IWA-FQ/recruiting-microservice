package com.polylink.recruitingMicroservice.repositories;

import com.polylink.recruitingMicroservice.entity.Apply;
import com.polylink.recruitingMicroservice.entity.ApplyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, ApplyId> {

     List<Apply> findAll();


     List<Apply> findAppliesById_IdApplicant(Long id_applicant);

     Apply findApplyById(ApplyId id);

     Apply save(Apply apply);


     @Override
     void deleteById(ApplyId applyId);
}
