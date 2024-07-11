package com.lloyds.cab.Cab.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double lat;
    private double lng;
    private String address;
    private String hash;
}
