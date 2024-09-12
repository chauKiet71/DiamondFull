package com.example.diamond.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Authorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    @ManyToOne
    @JoinColumn(name = "username")
    public Account account;

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Roles role;
}
