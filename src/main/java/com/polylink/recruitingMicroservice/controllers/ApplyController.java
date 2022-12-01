package com.polylink.recruitingMicroservice.controllers;

import com.polylink.recruitingMicroservice.entity.Apply;
import com.polylink.recruitingMicroservice.payload.response.MessageResponse;
import com.polylink.recruitingMicroservice.security.services.UserDetailsImpl;
import com.polylink.recruitingMicroservice.services.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/apply")
public class ApplyController
{
    @Autowired
    private ApplyService applyService;

    @GetMapping()
    public List<Apply> getAll() {
        return applyService.getAll();
    }
    @GetMapping("/{id_offer}/applicant/{id_applicant}")
    public Apply getById(@PathVariable("id_offer") Integer id_offer, @PathVariable("id_applicant") Long id_applicant) {
        return applyService.getByOfferAndApplicant(id_offer,id_applicant);
    }

    /**
     *
     * @return all apply offer for who do the request
     */
    @GetMapping("/applicant")
    public List<Apply> getAllOfferForApplicant(Principal principal) {
        UsernamePasswordAuthenticationToken userDetails = (UsernamePasswordAuthenticationToken) principal;
        UserDetailsImpl user = (UserDetailsImpl) userDetails.getPrincipal();

        return applyService.getAllOfferForApplicant(user.getId());
    }

    @PostMapping("/{id_offer}")
    public ResponseEntity<?> apply(@PathVariable("id_offer") Integer id_offer, Principal principal) {
        UsernamePasswordAuthenticationToken userDetails = (UsernamePasswordAuthenticationToken) principal;
        UserDetailsImpl user = (UserDetailsImpl) userDetails.getPrincipal();

        applyService.apply(id_offer,user.getId());
        return ResponseEntity.ok(new MessageResponse("Offre candidaté avec succès"));
    }

}
