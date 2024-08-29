package com.sab.student.dto;

import com.sab.student.model.Institution;
import com.sab.student.model.InstitutionType;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class InstitutionDTO {
    private String id;
    private String name;
    private String institutionTypeName;
    private String municipalityName;
    private String address;

    public InstitutionDTO convertToDTO(Institution institution) {
        InstitutionDTO dto = new InstitutionDTO();
        dto.setId(institution.getId());
        dto.setName(institution.getName());
        dto.setAddress(institution.getAddress());
        if (institution.getInstitutionType() != null) {
            dto.setInstitutionTypeName(institution.getInstitutionType().getName());
        }
        if (institution.getMunicipality() != null) {
            dto.setMunicipalityName(institution.getMunicipality().getName());
        }
        return dto;
    }

    public List<InstitutionDTO> convertToDTOList(List<Institution> institutions) {
        return institutions.stream().map(institution -> {
            return convertToDTO(institution);
        }).collect(Collectors.toList());
    }

}