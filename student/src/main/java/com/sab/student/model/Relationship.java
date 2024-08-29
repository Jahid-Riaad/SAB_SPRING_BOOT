package com.sab.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Relationship {
    @Id
    private String id;
    @Column( nullable = false, unique = true, length = 250)
    private String name;

    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }

}
