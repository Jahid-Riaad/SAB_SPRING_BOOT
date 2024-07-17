package com.sab.localresource.model;

import com.sab.localresource.request.MunicipalityRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.security.PublicKey;
import java.util.UUID;

@Data
@Entity
public class Municipality {
    @Id
    private String municipalityId;
    @Column(nullable = false, unique = true)
    @Size(max = 250)
    private String municipalityName;

    public Municipality() {
    }
    public Municipality(MunicipalityRequest municipalityName) {
        this.municipalityName = municipalityName.getMunicipalityName();
    }

    @PrePersist
    public void prePersist(){
        if (this.municipalityId == null){
            this.municipalityId = UUID.randomUUID().toString();
        }
    }


}
