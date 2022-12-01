package com.polylink.recruitingMicroservice.services;

import com.polylink.recruitingMicroservice.entity.Apply;
import com.polylink.recruitingMicroservice.entity.Recruiting;
import com.polylink.recruitingMicroservice.entity.RecruitingId;
import com.polylink.recruitingMicroservice.repositories.ApplyRepository;
import com.polylink.recruitingMicroservice.repositories.RecruitingRepository;
import com.polylink.recruitingMicroservice.security.model.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecruitingService {

    @Autowired
    private RecruitingRepository recruitingRepository;

    @Autowired
    private ApplyRepository applyRepository;

    public List<Recruiting> getAll() {
        return recruitingRepository.findAll();
    }

    public Optional<Recruiting> getByOfferAndApplicant(Integer id_offer, Long id_employee) {
        RecruitingId recruitingId = new RecruitingId(id_offer,id_employee);
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
    public void rateSomeone(Integer id_offer, Long id_employee, Integer rate, ERole role) throws Exception {
        RecruitingId recruitingId = new RecruitingId(id_offer,id_employee);
        Optional<Recruiting> recruiting = recruitingRepository.findRecruitingById(recruitingId);
        recruiting.orElseThrow(() -> new RuntimeException("Error: Recruiting not found."));
        if(role == ERole.ROLE_EMPLOYEE) { this.rateEmployee(recruiting.get(),rate);}
        else if(role == ERole.ROLE_RECRUITER){ this.rateEmployer(recruiting.get(),rate);}
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
