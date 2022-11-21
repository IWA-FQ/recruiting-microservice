package com.example.recruitingMicroservice.controllers;

import com.example.recruitingMicroservice.entity.Recruiting;
import com.example.recruitingMicroservice.repositories.RecruitingRepository;
import com.example.recruitingMicroservice.services.RecruitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController

public class RecruitingController
{
    @Autowired
    private RecruitingService recruitingService;

    @GetMapping("/api")
    public String resource(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Resource accessed by: %s (with subjectId: %s)" ,
                jwt.getClaims().get("preferred_username"),
                jwt.getSubject());
    }
    @GetMapping("/api/test")
    public Principal test(@AuthenticationPrincipal Jwt jwt, Principal principal) {
        return principal;
    }

    @GetMapping("/api/recruiting/all")
    public List<Recruiting> getAllRecruting() {
        return recruitingService.getAll();
    }
    @GetMapping("/api/recruiting/{id_recruiting}")
    public Recruiting getById(@PathVariable("id_recruiting") Integer id) {
        return recruitingService.getById(id);
    }



}
