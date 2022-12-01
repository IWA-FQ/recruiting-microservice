package com.polylink.recruitingMicroservice.repositories;

import com.polylink.recruitingMicroservice.entity.Recruiting;
import com.polylink.recruitingMicroservice.entity.RecruitingId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecruitingRepository extends JpaRepository<Recruiting, RecruitingId> {

     List<Recruiting> findAll();

     Optional<Recruiting> findRecruitingById(RecruitingId id);

     Recruiting save(Recruiting recruiting);

     @Override
     void deleteById(RecruitingId id);
}
