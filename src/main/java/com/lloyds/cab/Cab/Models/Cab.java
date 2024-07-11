package com.lloyds.cab.Cab.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String registrationPlate;
    private String originAddress;
    private String originHash;
    private int capacity;
    private boolean pickUp;
    private boolean dropOff;
}
