package com.hrms.empilot.shared.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@MappedSuperclass 
@Getter 
@Setter 
@SuperBuilder  
@AllArgsConstructor 
@NoArgsConstructor 
public abstract class BaseAuditingEntity implements Serializable {

    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @CreatedDate 
    @Column(name = "created_at", nullable =  false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate 
    @Column(name = "updated_at", nullable =  false)
    private Instant updatedAt;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private Boolean active = true; 
}
