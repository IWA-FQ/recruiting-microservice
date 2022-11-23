package com.example.recruitingMicroservice.services;

import com.example.recruitingMicroservice.entity.Apply;
import com.example.recruitingMicroservice.entity.Recruiting;
import com.example.recruitingMicroservice.entity.RecruitingId;
import com.example.recruitingMicroservice.repositories.ApplyRepository;
import com.example.recruitingMicroservice.repositories.RecruitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecruitingService {

    @Autowired
    private RecruitingRepository recruitingRepository;

    @Autowired
    private ApplyRepository applyRepository;

    public List<Recruiting> getAll() {
        return recruitingRepository.findAll();
    }

    public Recruiting getByOfferAndApplicant(Integer id_offer, Integer id_employee) {
        RecruitingId recruitingId = new RecruitingId(id_employee,id_offer);
        return recruitingRepository.findRecruitingById(recruitingId);
    }

    /**
     *
     * @param apply
     */
    public void hireSomeone(Apply apply) {
        Recruiting recruiting = new Recruiting();
        RecruitingId recruitingId = new RecruitingId(apply.getId().getIdOffer(),apply.getId().getIdApplicant());
        recruiting.setId(recruitingId);
        recruitingRepository.save(recruiting);
        applyRepository.delete(apply);
    }

    /**
     *
     * @param id_offer
     * @param id_employee
     * @param rate
     * @param role
     */
    public void rateSomeone(Integer id_offer, Integer id_employee, Integer rate, String role) {
        RecruitingId recruitingId = new RecruitingId(id_offer,id_employee);
        Recruiting recruiting = recruitingRepository.findRecruitingById(recruitingId);
        if(role == "employer") { this.rateEmployee(recruiting,rate);}
        else if(role == "jobseeker"){ this.rateEmployee(recruiting,rate);}
    }

    /**
     * @param recruiting
     * @param rate
     */
    private void rateEmployer(Recruiting recruiting, Integer rate) {
        recruiting.setRateEmployer(rate);
        recruitingRepository.save(recruiting);
    }

    /**
     * @param recruiting
     * @param rate
     */
    private void rateEmployee(Recruiting recruiting, Integer rate) {
        recruiting.setRateEmployee(rate);
        recruitingRepository.save(recruiting);
    }
}
