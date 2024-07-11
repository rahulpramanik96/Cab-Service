package com.lloyds.cab.Cab.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cab_booking_request_details")
public class CabBookingRequestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "drop_off", nullable = false)
    private boolean dropOff;

    @Column(name = "pick_up", nullable = false)
    private boolean pickUp;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}