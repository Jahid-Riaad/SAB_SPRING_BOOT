package com.sab.localresource.model;

import com.sab.localresource.request.InstitutionTypeRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionType {
    @Id
    private String typeId;
    @Column(nullable = false, unique = true)
    @Size(max = 250)
    private String typeName;

    public InstitutionType(InstitutionTypeRequest institutionTypeRequest) {
        this.typeName = institutionTypeRequest.getInstitutionType();
    }

    @PrePersist
    public void prePersist(){
        if (this.typeId == null){
            this.typeId = UUID.randomUUID().toString();
        }
    }

}
