package com.example.recruitingMicroservice.repositories;

import com.example.recruitingMicroservice.entity.Apply;
import com.example.recruitingMicroservice.entity.Recruiting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitingRepository extends JpaRepository<Recruiting, Integer> {

     List<Recruiting> findAll();

     List<Recruiting> findAllByEmployer(Integer id_employer);

     Recruiting findRecruitingBy(Integer id_recruiting);

     Recruiting save(Recruiting recruiting);

     @Override
     void deleteById(Integer integer);
}
