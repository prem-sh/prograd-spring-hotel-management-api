package com.prem.hotelmanagement.api.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "booking_status")
public class BookingStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "bookingStatus", cascade = CascadeType.ALL)
    private List<Booking> bookings = new java.util.ArrayList<>();
}
