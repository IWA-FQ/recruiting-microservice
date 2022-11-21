package com.example.recruitingMicroservice.repositories;

import com.example.recruitingMicroservice.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {

     List<Apply> findAll();

     List<Apply> findAppliesByApplicant(String id_jobseeker);

     Apply findApplyById(Integer id_apply);

     Apply save(Apply apply);

     @Override
     void deleteById(Integer integer);
}
