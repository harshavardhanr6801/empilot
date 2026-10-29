package com.hrms.empilot.leads.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hrms.empilot.leads.dto.request.LeadCreateRequest;
import com.hrms.empilot.leads.dto.request.LeadStatusUpdate;
import com.hrms.empilot.leads.dto.request.LeadUpdateRequest;
import com.hrms.empilot.leads.dto.response.LeadCreateResponse;
import com.hrms.empilot.leads.dto.response.LeadStatusUpdateResponse;
import com.hrms.empilot.leads.dto.response.LeadUpdateResponse;
import com.hrms.empilot.leads.entity.Leads;
import com.hrms.empilot.leads.enums.LeadStatus;
import com.hrms.empilot.leads.mapper.LeadMapper;
import com.hrms.empilot.leads.repository.LeadRepository;
import com.hrms.empilot.leads.service.LeadService;
import com.hrms.empilot.shared.exception.DuplicateLeadException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j 
public class LeadServiceImpl implements LeadService{

    private final LeadMapper leadMapper;
    private final LeadRepository leadRepository;

    public LeadServiceImpl(LeadMapper leadMapper, LeadRepository leadRepository) {
        this.leadMapper = leadMapper;
        this.leadRepository = leadRepository;
    }

    @Override
    @Transactional 
    public LeadCreateResponse createLead(LeadCreateRequest leadCreateRequest) {

        if (leadRepository.existsByEmail(leadCreateRequest.getEmail())) {
            throw new DuplicateLeadException("A lead with this email already exists: " + leadCreateRequest.getEmail());
        }

        Leads leads = leadMapper.mapToEntity(leadCreateRequest);
        leads.setLeadStatus(LeadStatus.NEW);
        Leads saveLead = leadRepository.save(leads);
        log.info("Lead created successfully. leadId={}", saveLead.getId());
        return leadMapper.mapToResponse(saveLead);
    }

    
    @Override
    public List<LeadCreateResponse> getAllLeads() {

        return leadRepository.findByActiveTrue()
                .stream()
                .map(leadMapper::mapToResponse)
                .toList();
    }

    @Override
    @Transactional
    public LeadStatusUpdateResponse updateStatus(UUID id, LeadStatusUpdate leadStatusUpdate) {

        Leads existingLead = leadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lead not found: " + id));

        LeadStatus previousStatus = existingLead.getLeadStatus();
        existingLead.setLeadStatus(leadStatusUpdate.getLeadStatus());
        Leads updateLead = leadRepository.save(existingLead);

        return LeadStatusUpdateResponse.builder()
                .id(updateLead.getId())
                .previousStatus(previousStatus)
                .currentStatus(updateLead.getLeadStatus())
                .updatedAt(updateLead.getUpdatedAt())
                .build();

    }

    @Override
    public LeadCreateResponse findByEmail(String email) {
        Leads lead = leadRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Lead not found: " + email));
        return leadMapper.mapToResponse(lead);
    }

    @Override
    @Transactional 
    public void deleteLead(UUID id) {
        
        Leads lead = leadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lead not found: " + id));

        if(!Boolean.TRUE.equals(lead.getActive())){
            log.debug("Lead is already inactive. leadId={}", id);
            return;
        }

        lead.setActive(false);
        leadRepository.save(lead);
        log.info("Lead deleted successfully. leadId={}", id);
    }


    @Override
    @Transactional 
    public LeadUpdateResponse updateLead(UUID id, LeadUpdateRequest leadUpdateRequest) {

        Leads leads = leadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lead not found: " + id));

        leadMapper.mapToUpdatedEntity(leadUpdateRequest, leads);
        Leads updateLead = leadRepository.save(leads);

        log.info("Lead updated successfully. leadId={}",updateLead.getId());

        return leadMapper.mapToUpdateResponse(updateLead);

    }

}
