package com.sab.localresource.model;

import com.sab.localresource.request.MunicipalityRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Municipality implements Serializable {
    @Id
    private String id;
    @Column(nullable = false, unique = true)
    @Size(max = 250)
    private String name;

    public Municipality() {
    }
    public Municipality(MunicipalityRequest name) {
        this.name = name.getMunicipality();
    }

    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }


}
