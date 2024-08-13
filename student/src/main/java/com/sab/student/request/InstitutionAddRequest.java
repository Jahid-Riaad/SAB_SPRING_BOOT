package com.sab.student.request;

import com.sab.student.model.InstitutionType;
import com.sab.student.model.Municipality;
import lombok.Data;

@Data
public class InstitutionAddRequest {
    private String name;
    private InstitutionType institutionType;
    private Municipality municipality;
    private String address;
}
