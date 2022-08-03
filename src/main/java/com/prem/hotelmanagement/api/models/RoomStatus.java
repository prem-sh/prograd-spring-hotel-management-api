package com.prem.hotelmanagement.api.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "room_status")
public class RoomStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "roomStatus", cascade = CascadeType.ALL)
    private List<Room> rooms = new java.util.ArrayList<>();
}
