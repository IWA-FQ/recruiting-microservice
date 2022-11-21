package com.example.recruitingMicroservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recruiting")
public class Recruiting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "offer")
    private Integer offer;
    @Column(name = "employee")
    private String employee;
    @Column(name = "date")
    private Date date;
    @Column(name = "rate_employee")
    private Integer rate_employee;
    @Column(name = "rate_employer")
    private Integer rate_employer;

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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRate_employee() {
        return rate_employee;
    }

    public void setRate_employee(Integer rate_employee) {
        this.rate_employee = rate_employee;
    }

    public Integer getRate_employer() {
        return rate_employer;
    }

    public void setRate_employer(Integer rate_employer) {
        this.rate_employer = rate_employer;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + this.getId() +
                ", offer='" + this.getOffer() +
                ", applicant='" + this.getEmployee() +
                ", date='" + this.getDate() +
                ", rate_employee='" + this.getRate_employee() +
                ", rate_employer='" + this.getRate_employer() +
                '}';
    }
}
