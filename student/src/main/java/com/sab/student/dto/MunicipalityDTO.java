package com.sab.student.dto;

import com.sab.student.model.Municipality;
import lombok.Data;

@Data
public class MunicipalityDTO {
    private String id;
    private String name;

    public MunicipalityDTO convertToDTO(Municipality municipality) {
        MunicipalityDTO dto = new MunicipalityDTO();
        dto.setId(municipality.getId());
        dto.setName(municipality.getName());
        return dto;
    }
}
