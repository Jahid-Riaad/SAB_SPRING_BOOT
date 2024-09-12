package com.sab.security.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Authorities {
    @Id
    private String id;
    @Column( nullable = false, unique = true)
    @Size(max = 250)
    private String name;

}
