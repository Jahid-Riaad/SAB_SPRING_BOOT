package com.sab.security.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class UserProfile {
    @Id
    private String id;
    @Column( nullable = false, unique = true)
    @Size(max = 250)
    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER) // Change to EAGER
    @JoinColumn(referencedColumnName = "id")
    private Authorities authorities;

    private Boolean enabled;
}
