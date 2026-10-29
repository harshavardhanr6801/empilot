package com.hrms.empilot.leads.dto.request;

import com.hrms.empilot.leads.enums.EmployeeCount;
import com.hrms.empilot.leads.enums.LeadSource;
import com.hrms.empilot.leads.enums.Sector;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class LeadCreateRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name cannot exceed 100 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 100, message = "Last name cannot exceed 100 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Size(max = 254, message = "Email cannot exceed 254 characters")
    private String email;

    @Pattern(regexp = "^[+()0-9 .-]{7,20}$", message = "Please provide a valid phone number")
    private String phoneNumber;

    @NotBlank(message = "Company name is required")
    @Size(max = 150, message = "Company name cannot exceed 150 characters")
    private String companyName;

    @NotNull(message = "Sector is required")
    private Sector sector;

    @NotNull(message = "Employee count is required")
    private EmployeeCount employeeCount;

    @NotNull(message = "Lead source is required")
    private LeadSource leadSource;

}
