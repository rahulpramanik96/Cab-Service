package com.lloyds.cab.Cab.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ConfirmedCabBookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "cab_id")
    private Cab cab;

    @OneToMany
    //@JoinColumn(name = "confirmed_cab_booking_id") // Column in User table to reference this entity
    private List<User> users;
}
