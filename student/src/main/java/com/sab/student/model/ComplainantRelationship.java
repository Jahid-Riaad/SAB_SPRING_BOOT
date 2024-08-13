package com.sab.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
public class ComplainantRelationship {
    @Id
    private String id;
    @Column( nullable = false, unique = true, length = 50)
    private String relationshipName;
    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }
}