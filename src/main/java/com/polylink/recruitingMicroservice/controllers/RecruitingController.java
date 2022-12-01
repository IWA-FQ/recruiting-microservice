package com.polylink.recruitingMicroservice.controllers;

import com.polylink.recruitingMicroservice.entity.Apply;
import com.polylink.recruitingMicroservice.entity.ApplyId;
import com.polylink.recruitingMicroservice.entity.Recruiting;
import com.polylink.recruitingMicroservice.payload.request.RateEmployeeRequest;
import com.polylink.recruitingMicroservice.payload.request.RecruteRequest;
import com.polylink.recruitingMicroservice.payload.response.MessageResponse;
import com.polylink.recruitingMicroservice.security.model.ERole;
import com.polylink.recruitingMicroservice.security.services.UserDetailsImpl;
import com.polylink.recruitingMicroservice.services.RecruitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<?> getById(@PathVariable("id_offer") Integer id_offer, @PathVariable("id_employee") Long id_employee) {
        Optional<Recruiting> recruiting= recruitingService.getByOfferAndApplicant(id_offer,id_employee);
        if(recruiting.isPresent())
            return ResponseEntity.ok(recruiting.get());
        else
            return ResponseEntity.badRequest().body(new MessageResponse("Recrutement non trouvé"));
    }
    @PostMapping("/rate/employee/{id_offer}")
    public ResponseEntity<?> rateEmployee(@PathVariable("id_offer") Integer id_offer, @RequestBody RateEmployeeRequest rateRequest) {
        try {
            recruitingService.rateSomeone(id_offer, rateRequest.getId_applicant(), rateRequest.getRating(), ERole.ROLE_EMPLOYEE);
            return ResponseEntity.ok(new MessageResponse("Employer noté avec succès"));

        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(e.getMessage()));
        }

    }

    @PostMapping("/rate/employer/{id_offer}")
    public  ResponseEntity<?>  rateEmployer(@PathVariable("id_offer") Integer id_offer, Principal principal,@RequestBody Integer rate) {
        UsernamePasswordAuthenticationToken userDetails = (UsernamePasswordAuthenticationToken) principal;
        UserDetailsImpl user = (UserDetailsImpl) userDetails.getPrincipal();

        try {
            recruitingService.rateSomeone(id_offer,user.getId(),rate, ERole.ROLE_RECRUITER);
            return ResponseEntity.ok(new MessageResponse("Recruteur noté avec succès"));
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse( e.getMessage()));
        }

    }
    @PostMapping
    public ResponseEntity<?> postRecruiting(@RequestBody RecruteRequest recruteRequest) {

        Apply apply = new Apply();
        apply.setId(new ApplyId(recruteRequest.getId_applicant(),recruteRequest.getId_offer()));

        recruitingService.hireSomeone(apply);

        return ResponseEntity.ok(new MessageResponse("Recrutement fait avec succès"));
    }

}
