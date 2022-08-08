package com.prem.hotelmanagement.api.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "role_name", nullable = false)
    @JacksonXmlProperty(isAttribute = true)
    String roleName;
}
