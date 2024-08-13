package com.sab.student.model;

import com.sab.student.request.InstitutionTypeAddRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionType implements Serializable {
    @Id
    private String id;
    @Column(nullable = false, unique = true)
    @Size(max = 250)
    private String name;

    public InstitutionType(InstitutionTypeAddRequest institutionTypeAddRequest) {
        this.name = institutionTypeAddRequest.getName();
    }

    public InstitutionType(InstitutionType institutionType) {
        this.id = institutionType.id;
        this.name = institutionType.name;
    }

    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }

}
