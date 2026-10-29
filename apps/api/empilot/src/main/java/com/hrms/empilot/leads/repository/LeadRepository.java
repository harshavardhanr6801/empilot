package com.hrms.empilot.leads.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.empilot.leads.entity.Leads;

public interface LeadRepository extends JpaRepository<Leads,UUID> {

    Optional<Leads> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Leads> findByActiveTrue();


}
