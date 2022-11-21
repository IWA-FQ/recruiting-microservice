package com.example.recruitingMicroservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "apply")
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "offer")
    private Integer offer;
    @Column(name = "applicant")
    private String applicant;
    @Column(name = "date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOffer() {
        return offer;
    }

    public void setOffer(Integer offer) {
        this.offer = offer;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + this.getId() +
                ", offer='" + this.getOffer() +
                ", applicant='" + this.getApplicant() +
                ", date='" + this.getDate() +
                '}';
    }
}
