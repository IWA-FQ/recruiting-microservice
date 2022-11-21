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
public class RecruitingService {

    @Autowired
    private RecruitingRepository recruitingRepository;

    @Autowired
    private ApplyRepository applyRepository;

    public List<Recruiting> getAll() {
        return recruitingRepository.findAll();
    }

    public Recruiting getById(Integer id_recruiting) {
        return recruitingRepository.findRecruitingBy(id_recruiting);
    }

    /**
     *
     * @param apply
     */
    public void hireSomeone(Apply apply) {
        Recruiting recruiting = new Recruiting();
        recruiting.setOffer(apply.getOffer());
        recruiting.setEmployee(apply.getApplicant());
        Date date = new Date();
        System.out.println(date);
        recruiting.setDate(date);
        recruitingRepository.save(recruiting);
        applyRepository.deleteById(apply.getId());
    }

    /**
     *
     * @param id_recruiting
     * @param rate
     * @param role
     */
    public void rateSomeone(Integer id_recruiting, Integer rate, String role) {
        if(role == "employer") { this.rateEmployee(id_recruiting,rate);}
        else if(role == "employee"){ this.rateEmployee(id_recruiting,rate);}
    }

    /**
     *
     * @param id_recruiting
     * @param rate
     */
    private void rateEmployer(Integer id_recruiting, Integer rate) {
        Recruiting recruiting = recruitingRepository.findRecruitingBy(id_recruiting);
        recruiting.setRate_employer(rate);
        recruitingRepository.save(recruiting);
    }

    /**
     *
     * @param id_recruiting
     * @param rate
     */
    private void rateEmployee(Integer id_recruiting, Integer rate) {
        Recruiting recruiting = recruitingRepository.findRecruitingBy(id_recruiting);
        recruiting.setRate_employee(rate);
        recruitingRepository.save(recruiting);
    }
}
