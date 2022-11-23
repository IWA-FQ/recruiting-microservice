package com.example.recruitingMicroservice.services;

import com.example.recruitingMicroservice.entity.Apply;
import com.example.recruitingMicroservice.entity.ApplyId;
import com.example.recruitingMicroservice.repositories.ApplyRepository;
import com.example.recruitingMicroservice.repositories.RecruitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    public Apply getByOfferAndApplicant(Integer id_offer, Integer id_applicant) {
        ApplyId applyId = new ApplyId(id_applicant,id_offer);
        return applyRepository.findApplyById(applyId);
    }

    public void apply(Integer id_offer, Integer id_applicant) {
        Apply apply = new Apply();
        ApplyId applyId = new ApplyId();
        applyId.setIdApplicant(id_applicant);
        applyId.setIdOffer(id_offer);
        apply.setId(applyId);
        Timestamp time = new Timestamp(0);
        System.out.println(time);
        apply.setLastUpdated(time);
        applyRepository.save(apply);
    }

    public void deleteApplyById(ApplyId id_apply){
        applyRepository.deleteById(id_apply);
    }

}
