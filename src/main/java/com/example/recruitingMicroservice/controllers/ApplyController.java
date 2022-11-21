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
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;


@RestController

public class ApplyController
{
    @Autowired
    private ApplyService applyService;

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

    @GetMapping("/api/recruiting/apply/all")
    public List<Apply> getAll() {
        return applyService.getAll();
    }
    @GetMapping("/api/recruiting/apply/{id_apply}")
    public Apply getById(@PathVariable("id_apply") Integer id) {
        return applyService.getById(id);
    }

}
