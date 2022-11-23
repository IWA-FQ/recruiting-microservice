package com.example.recruitingMicroservice.controllers;

import com.example.recruitingMicroservice.entity.Recruiting;
import com.example.recruitingMicroservice.repositories.RecruitingRepository;
import com.example.recruitingMicroservice.services.RecruitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/recruiting")
public class RecruitingController
{
    @Autowired
    private RecruitingService recruitingService;

    @GetMapping("/all")
    public List<Recruiting> getAllRecruting() {
        return recruitingService.getAll();
    }
    @GetMapping("/{id_offer}/employee/{id_employee}")
    public Recruiting getById(@PathVariable("id_offer") Integer id_offer, @PathVariable("id_employee") Integer id_employee) {
        return recruitingService.getByOfferAndApplicant(id_offer,id_employee);
    }

}
