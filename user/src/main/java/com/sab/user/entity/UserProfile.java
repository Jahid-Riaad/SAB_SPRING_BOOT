package com.sab.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class UserProfile{
    @Id
    @Size(max = 250)
    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER) // Change to EAGER
    @JoinColumn(referencedColumnName = "id")
    private Authority authority;

    private Boolean enabled;
}
