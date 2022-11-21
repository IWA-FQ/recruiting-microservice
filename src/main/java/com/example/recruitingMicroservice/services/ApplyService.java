package com.example.recruitingMicroservice.services;

import com.example.recruitingMicroservice.entity.Apply;
import com.example.recruitingMicroservice.entity.Recruiting;
import com.example.recruitingMicroservice.repositories.ApplyRepository;
import com.example.recruitingMicroservice.repositories.RecruitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplyService {

    @Autowired
    private ApplyRepository applyRepository;

    @Autowired
    private RecruitingRepository recruitingRepository;

    public List<Apply> getAll() {
        return applyRepository.findAll();
    }

    public Apply getById(Integer id_recruiting) {
        return applyRepository.findApplyById(id_recruiting);
    }

    public void apply(Integer id_offer, String id_applicant) {
        Apply apply = new Apply();
        apply.setOffer(id_offer);
        apply.setApplicant(id_applicant);
        Date date = new Date();
        System.out.println(date);
        apply.setDate(date);
        applyRepository.save(apply);
    }

    public void deleteApplyById(Integer id_apply){
        applyRepository.deleteById(id_apply);
    }


}
