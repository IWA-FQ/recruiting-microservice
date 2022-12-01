package com.polylink.recruitingMicroservice.services;

import com.polylink.recruitingMicroservice.entity.Apply;
import com.polylink.recruitingMicroservice.entity.ApplyId;
import com.polylink.recruitingMicroservice.repositories.ApplyRepository;
import com.polylink.recruitingMicroservice.repositories.RecruitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    public Apply getByOfferAndApplicant(Integer id_offer, Long id_applicant) {
        ApplyId applyId = new ApplyId(id_applicant,id_offer);
        return applyRepository.findApplyById(applyId);
    }
    public List<Apply> getAllOfferForApplicant(Long id_applicant){
        return applyRepository.findAppliesById_IdApplicant(id_applicant);
    }

    public void apply(Integer id_offer, Long id_applicant) {
        Apply apply = new Apply();
        ApplyId applyId = new ApplyId();
        applyId.setIdApplicant(id_applicant);
        applyId.setIdOffer(id_offer);
        apply.setId(applyId);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        apply.setLastUpdated(time);
        applyRepository.save(apply);
    }

    public void deleteApplyById(ApplyId id_apply){
        applyRepository.deleteById(id_apply);
    }

}
