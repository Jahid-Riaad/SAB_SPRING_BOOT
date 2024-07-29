package com.sab.localresource.request;

import com.sab.localresource.model.InstitutionType;
import com.sab.localresource.model.Municipality;
import lombok.Data;

@Data
public class InstitutionAddRequest {
    private String name;
    private InstitutionType institutionType;
    private Municipality municipality;
    private String address;
}
