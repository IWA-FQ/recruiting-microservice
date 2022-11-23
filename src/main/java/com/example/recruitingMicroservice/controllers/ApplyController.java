package com.example.recruitingMicroservice.controllers;

import com.example.recruitingMicroservice.entity.Apply;
import com.example.recruitingMicroservice.entity.Recruiting;
import com.example.recruitingMicroservice.repositories.RecruitingRepository;
import com.example.recruitingMicroservice.services.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/apply")
public class ApplyController
{
    @Autowired
    private ApplyService applyService;

    @GetMapping("/all")
    public List<Apply> getAll() {
        return applyService.getAll();
    }
    @GetMapping("/{id_offer}/applicant/{id_applicant}")
    public Apply getById(@PathVariable("id_offer") Integer id_offer, @PathVariable("id_applicant") Integer id_applicant) {
        return applyService.getByOfferAndApplicant(id_offer,id_applicant);
    }

}
