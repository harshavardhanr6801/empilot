package com.hrms.empilot.leads.dto.request;

import com.hrms.empilot.leads.enums.LeadStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class LeadStatusUpdate {

    @NotNull(message = "Lead status is required")
    private LeadStatus leadStatus;

}
