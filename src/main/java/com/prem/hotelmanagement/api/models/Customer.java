package com.prem.hotelmanagement.api.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    private List<Booking> bookings = new java.util.ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = true, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = true, updatable = false)
    private Date updatedAt;

    @PrePersist
    void onCreate(){
        this.setCreatedAt(new Date());
    }

    @PreUpdate
    void onUpdate(){
        this.setUpdatedAt(new Date());
    }
}