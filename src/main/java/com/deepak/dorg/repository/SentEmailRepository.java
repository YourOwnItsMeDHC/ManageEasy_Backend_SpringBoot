package com.deepak.dorg.repository;

import com.deepak.dorg.model.SentEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentEmailRepository extends JpaRepository<SentEmail, Long> {
}
