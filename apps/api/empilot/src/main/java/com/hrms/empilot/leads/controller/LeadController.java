package com.hrms.empilot.leads.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.empilot.leads.dto.request.LeadCreateRequest;
import com.hrms.empilot.leads.dto.request.LeadStatusUpdate;
import com.hrms.empilot.leads.dto.request.LeadUpdateRequest;
import com.hrms.empilot.leads.dto.response.LeadCreateResponse;
import com.hrms.empilot.leads.dto.response.LeadStatusUpdateResponse;
import com.hrms.empilot.leads.dto.response.LeadUpdateResponse;
import com.hrms.empilot.leads.service.LeadService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/leads")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping(path = "", version = "1.0")
    public ResponseEntity<LeadCreateResponse> createLead(@Valid @RequestBody LeadCreateRequest request) {
        LeadCreateResponse response = leadService.createLead(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(version = "1.0")
    public ResponseEntity<List<LeadCreateResponse>> getAllLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @GetMapping(path = "/search", version = "1.0")
    public ResponseEntity<LeadCreateResponse> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(leadService.findByEmail(email));
    }

    @PatchMapping(path = "/{id}", version = "1.0")
    public ResponseEntity<LeadUpdateResponse> updateLead(@PathVariable UUID id,
            @Valid @RequestBody LeadUpdateRequest request) {

        return ResponseEntity.ok(leadService.updateLead(id, request));
    }

    @PatchMapping(path = "/{id}/status", version = "1.0")
    public ResponseEntity<LeadStatusUpdateResponse> updateStatus(@PathVariable UUID id, 
        @Valid @RequestBody LeadStatusUpdate request) {

        return ResponseEntity.ok(leadService.updateStatus(id, request));
    }

    @DeleteMapping(path = "/{id}", version = "1.0")
    public ResponseEntity<Void> deleteLead(@PathVariable UUID id) {

        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }

}
