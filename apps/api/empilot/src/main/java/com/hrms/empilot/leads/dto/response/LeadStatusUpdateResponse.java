package com.hrms.empilot.leads.dto.response;

import java.time.Instant;
import java.util.UUID;

import com.hrms.empilot.leads.enums.LeadStatus;

import lombok.Builder;
import lombok.Getter;

@Getter 
@Builder 
public class LeadStatusUpdateResponse {

    private UUID id;

    private LeadStatus previousStatus;
    private LeadStatus currentStatus;

    private Instant updatedAt;

}
