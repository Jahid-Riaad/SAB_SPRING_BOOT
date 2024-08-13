package com.sab.student.model;

import com.sab.student.request.MunicipalityAddRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
public class Municipality implements Serializable {
    @Id
    private String id;
    @Column(nullable = false, unique = true)
    @Size(max = 250)
    private String name;

    public Municipality() {
    }
    public Municipality(Municipality municipality) {
        this.id = municipality.getId();
        this.name = municipality.getName();
    }
    public Municipality(MunicipalityAddRequest municipalityAddRequest) {
        this.name = municipalityAddRequest.getName();
    }
    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }


}
