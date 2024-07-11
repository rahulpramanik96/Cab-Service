package com.lloyds.cab.Cab.DAO;

import com.lloyds.cab.Cab.Models.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepository extends JpaRepository<Cab, Integer> {
}
