package com.polylink.recruitingMicroservice.payload.request;

public class RecruteRequest {
    private Long id_applicant;
    private Integer id_offer;

    public Long getId_applicant() {
        return id_applicant;
    }

    public void setId_applicant(Long id_applicant) {
        this.id_applicant = id_applicant;
    }

    public Integer getId_offer() {
        return id_offer;
    }

    public void setId_offer(Integer id_offer) {
        this.id_offer = id_offer;
    }
}
