package com.hrms.empilot.leads.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrms.empilot.leads.dto.request.LeadCreateRequest;
import com.hrms.empilot.leads.dto.request.LeadUpdateRequest;
import com.hrms.empilot.leads.dto.response.LeadCreateResponse;
import com.hrms.empilot.leads.dto.response.LeadUpdateResponse;
import com.hrms.empilot.leads.entity.Leads;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LeadMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "leadStatus", ignore = true)
    Leads mapToEntity (LeadCreateRequest leadCreateRequest);

    LeadCreateResponse mapToResponse(Leads leads);

    LeadUpdateResponse mapToUpdateResponse(Leads leads);

    void mapToUpdatedEntity(LeadUpdateRequest leadUpdateRequest, @MappingTarget Leads leads);

}
