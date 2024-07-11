package com.lloyds.cab.Cab.DAO;

import com.lloyds.cab.Cab.Models.CabBookingRequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabBookingRequestDetailsRepository extends JpaRepository<CabBookingRequestDetails,Integer> {
}
