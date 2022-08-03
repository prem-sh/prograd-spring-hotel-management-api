package com.prem.hotelmanagement.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    int roomId;
    @Column(name = "room_number", nullable = false, unique = true)
    int roomNo;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "room_type", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"rooms", "id"}, allowSetters = true)
    private RoomType roomType;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "room_status", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"rooms", "id"}, allowSetters = true)
    private RoomStatus roomStatus;

    @OneToMany(mappedBy = "roomId", cascade = CascadeType.REMOVE)
    private List<Booking> bookings = new java.util.ArrayList<>();

}