package com.sab.student.dto;

import com.sab.student.model.InstitutionType;
import com.sab.student.model.Municipality;
import lombok.Data;

@Data
public class InstitutionTypeDTO {
    private String id;
    private String name;

    public InstitutionTypeDTO convertToDTO(InstitutionType institutionType) {
        InstitutionTypeDTO dto = new InstitutionTypeDTO();
        dto.setId(institutionType.getId());
        dto.setName(institutionType.getName());
        return dto;
    }
}
