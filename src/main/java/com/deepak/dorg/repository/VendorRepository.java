package com.deepak.dorg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.dorg.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, String> {
}