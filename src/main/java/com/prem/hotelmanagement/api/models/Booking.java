package com.prem.hotelmanagement.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"bookings"}, allowSetters = true)
    @JacksonXmlProperty(localName = "Customer")
    private Customer customerId;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "room_id", nullable = false, referencedColumnName = "room_id")
    @JsonIgnoreProperties(value = {"bookings"}, allowSetters = true)
    @JacksonXmlProperty(localName = "Room")
    private Room roomId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "in_time", nullable = false)
    private Date inTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "out_time", nullable = true)
    private Date outTime;

    @Column(name = "rent")
    @JacksonXmlProperty(isAttribute = true)
    private double rent;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "booking_status", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"bookings","id"}, allowSetters = true)
    private BookingStatus bookingStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = true, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = true, updatable = false)
    private Date updatedAt;

    @PrePersist
    void onCreate(){
        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());
    }

    @PreUpdate
    void onUpdate(){
        this.setUpdatedAt(new Date());
    }

}
