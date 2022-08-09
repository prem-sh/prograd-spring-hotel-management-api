package com.prem.hotelmanagement.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private int id;
    @Column(name = "name", nullable = false, length = 30)
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "phone", nullable = false, length = 15)
    @JacksonXmlProperty(isAttribute = true)
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = true, updatable = false)
    @JacksonXmlProperty(isAttribute = true)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = true, updatable = false)
    @JacksonXmlProperty(isAttribute = true)
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
