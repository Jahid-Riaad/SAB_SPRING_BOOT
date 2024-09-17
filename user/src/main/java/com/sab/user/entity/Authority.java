package com.sab.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class Authority {
    @Id
    private String id;
    @Column( nullable = false, unique = true)
    @Size(max = 250)
    private String name;

}