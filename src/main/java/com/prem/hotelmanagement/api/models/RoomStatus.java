package com.prem.hotelmanagement.api.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "room_status")
public class RoomStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @OneToMany(mappedBy = "roomStatus", cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();
}
