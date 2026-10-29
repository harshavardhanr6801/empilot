package com.hrms.empilot.leads.entity;

import com.hrms.empilot.leads.enums.EmployeeCount;
import com.hrms.empilot.leads.enums.LeadSource;
import com.hrms.empilot.leads.enums.LeadStatus;
import com.hrms.empilot.leads.enums.Sector;
import com.hrms.empilot.shared.entity.BaseAuditingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Entity 
@Table (name = "emp_leads")
@Getter 
@Setter 
@SuperBuilder 
@AllArgsConstructor 
@NoArgsConstructor 
public class Leads extends BaseAuditingEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Enumerated (EnumType.STRING)
    @Column(name = "source", nullable = false)
    private Sector sector;

    @Enumerated (EnumType.STRING)
    @Column(name = "employee_count", nullable = false)
    private EmployeeCount employeeCount;

    @Enumerated (EnumType.STRING)
    @Column(name = "lead_source", nullable = false)
    private LeadSource leadSource;

    @Enumerated(EnumType.STRING)
    @Column(name = "lead_status", nullable = false)
    private LeadStatus leadStatus;

}
