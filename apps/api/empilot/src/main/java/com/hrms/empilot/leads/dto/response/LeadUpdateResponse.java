package com.hrms.empilot.leads.dto.response;

import java.time.Instant;
import java.util.UUID;

import com.hrms.empilot.leads.enums.EmployeeCount;
import com.hrms.empilot.leads.enums.LeadSource;
import com.hrms.empilot.leads.enums.LeadStatus;
import com.hrms.empilot.leads.enums.Sector;

import lombok.Builder;
import lombok.Getter;

@Getter 
@Builder 
public class LeadUpdateResponse {

    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String companyName;

    private Sector sector;
    private EmployeeCount employeeCount;

    private LeadSource leadSource;
    private LeadStatus leadStatus;

    private Instant createdAt;
    private Instant updatedAt;

}
