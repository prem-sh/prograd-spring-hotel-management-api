package com.prem.hotelmanagement.api.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "booking_status")
public class BookingStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name")
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @OneToMany(mappedBy = "bookingStatus", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new HashSet<>();
}
