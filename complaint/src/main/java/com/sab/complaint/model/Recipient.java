package com.sab.complaint.model;


import com.sab.complaint.request.RecipientRequest;
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
@AllArgsConstructor
@NoArgsConstructor
public class Recipient {
    @Id
    private String id;
    @Column( nullable = false, unique = true)
    @Size(max = 250)
    private String name;

    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }

    public Recipient convertToEntity(RecipientRequest recipientRequest) {
        this.setName(recipientRequest.getName());
        return this;
    }
}
