package com.example.com_rucinski.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "eventId", nullable = false)
    private SaleEvent saleEvent;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User seller;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public SaleEvent getSaleEvent() {
        return saleEvent;
    }

    public void setSaleEvent(SaleEvent saleEvent) {
        this.saleEvent = saleEvent;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Item() {
    }

    public Item(String name, Double price, SaleEvent saleEvent) {
        this.name = name;
        this.price = price;
        this.saleEvent = saleEvent;
    }
}
