package com.example.recruitingMicroservice.repositories;

import com.example.recruitingMicroservice.entity.Apply;
import com.example.recruitingMicroservice.entity.ApplyId;
import com.example.recruitingMicroservice.entity.Recruiting;
import com.example.recruitingMicroservice.entity.RecruitingId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitingRepository extends JpaRepository<Recruiting, RecruitingId> {

     List<Recruiting> findAll();

     Recruiting findRecruitingById(RecruitingId id);

     Recruiting save(Recruiting recruiting);

     @Override
     void deleteById(RecruitingId id);
}
