package com.polylink.recruitingMicroservice.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecruitingId implements Serializable {
    @Column(name = "id_employee")
    private Long idEmployee;
    @Column(name = "id_offer")
    private Integer idOffer;

    public RecruitingId(){}

    public RecruitingId(Integer idOffer, Long idEmployee) {
        this.idEmployee = idEmployee;
        this.idOffer = idOffer;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }

    @Override
    public String toString() {
        return "RecruitingId{" +
                "idEmployee=" + idEmployee +
                ", idOffer=" + idOffer +
                '}';
    }
}