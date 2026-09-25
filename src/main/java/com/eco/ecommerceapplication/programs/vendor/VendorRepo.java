package com.eco.ecommerceapplication.programs.vendor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepo extends JpaRepository<Vendor,Long> {
    Optional<Vendor> findByEmail(String email);

}
