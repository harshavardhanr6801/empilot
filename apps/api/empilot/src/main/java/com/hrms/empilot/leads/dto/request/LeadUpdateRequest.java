package com.hrms.empilot.leads.dto.request;

import com.hrms.empilot.leads.enums.EmployeeCount;
import com.hrms.empilot.leads.enums.Sector;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class LeadUpdateRequest {

    @Size(max = 100, message = "First name cannot exceed 100 characters")
    private String firstName;

    @Size(max = 100, message = "Last name cannot exceed 100 characters")
    private String lastName;

    @Email(message = "Please provide a valid email address")
    @Size(max = 254, message = "Email cannot exceed 254 characters")
    private String email;

    @Pattern(regexp = "^[+()0-9 .-]{7,20}$", message = "Please provide a valid phone number")
    private String phoneNumber;

    @Size(max = 150, message = "Company name cannot exceed 150 characters")
    private String companyName;

    private Sector sector;

    private EmployeeCount employeeCount;
    
}
