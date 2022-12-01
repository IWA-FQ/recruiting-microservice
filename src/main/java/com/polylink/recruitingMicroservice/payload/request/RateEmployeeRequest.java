package com.polylink.recruitingMicroservice.payload.request;

import javax.validation.constraints.NotBlank;

public class RateEmployeeRequest {
    @NotBlank
    private Long id_applicant;
    @NotBlank
    private Integer rating;


    public Long getId_applicant() {
        return id_applicant;
    }

    public void setId_applicant(Long id_applicant) {
        this.id_applicant = id_applicant;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RateEmployeeRequest{" +
                "id_applicant=" + id_applicant +
                ", rating=" + rating +
                '}';
    }
}
