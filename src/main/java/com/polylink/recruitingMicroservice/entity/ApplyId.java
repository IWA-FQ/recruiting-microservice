package com.polylink.recruitingMicroservice.entity;

import java.io.Serializable;

public class ApplyId implements Serializable {
    private Long idApplicant;
    private Integer idOffer;

    public ApplyId(){}

    public ApplyId(Long idApplicant, Integer idOffer) {
        this.idApplicant = idApplicant;
        this.idOffer = idOffer;
    }

    public Long getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(Long idApplicant) {
        this.idApplicant = idApplicant;
    }

    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }
}