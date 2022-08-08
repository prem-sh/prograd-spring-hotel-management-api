package com.prem.hotelmanagement.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Booking> bookings = new HashSet<>();

}