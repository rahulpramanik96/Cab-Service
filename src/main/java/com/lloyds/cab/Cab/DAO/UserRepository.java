package com.lloyds.cab.Cab.DAO;

import com.lloyds.cab.Cab.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
