package com.example.com_rucinski.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @Column(nullable = false)
    private Integer rating;

    @Column(length = 1024)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "eventId", nullable = false)
    private SaleEvent saleEvent;


    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public SaleEvent getSaleEvent() {
        return saleEvent;
    }

    public void setSaleEvent(SaleEvent saleEvent) {
        this.saleEvent = saleEvent;
    }
    public Rating() {
    }

    public Rating(Integer rating, SaleEvent saleEvent) {
        this.rating = rating;
        this.saleEvent = saleEvent;
    }
}
