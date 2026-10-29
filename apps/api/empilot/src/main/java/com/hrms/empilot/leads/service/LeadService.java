package com.hrms.empilot.leads.service;

import java.util.List;
import java.util.UUID;

import com.hrms.empilot.leads.dto.request.LeadCreateRequest;
import com.hrms.empilot.leads.dto.request.LeadStatusUpdate;
import com.hrms.empilot.leads.dto.request.LeadUpdateRequest;
import com.hrms.empilot.leads.dto.response.LeadCreateResponse;
import com.hrms.empilot.leads.dto.response.LeadStatusUpdateResponse;
import com.hrms.empilot.leads.dto.response.LeadUpdateResponse;

public interface LeadService {

    LeadCreateResponse createLead(LeadCreateRequest leadCreateRequest);

    List<LeadCreateResponse> getAllLeads();

    LeadUpdateResponse updateLead(UUID id, LeadUpdateRequest leadUpdateRequest);

    LeadStatusUpdateResponse updateStatus(UUID id, LeadStatusUpdate leadStatusUpdate);

    LeadCreateResponse findByEmail(String email);

    void deleteLead(UUID id);

}
