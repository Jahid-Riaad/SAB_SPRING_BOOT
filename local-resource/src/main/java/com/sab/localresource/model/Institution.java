package com.sab.localresource.model;

import com.sab.localresource.request.InstitutionRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution implements Serializable {

    @Id
    private String id;

    @Column( nullable = false, unique = true, length = 500)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( referencedColumnName = "id")
    private InstitutionType institutionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( referencedColumnName = "id")
    private Municipality municipality;

    @Column(name = "ADDRESS", length = 500)
    private String address;

    public Institution(InstitutionRequest institutionRequest) {
        this.name = institutionRequest.getInstitution();
    }

    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }

}